package br.com.geniustest.api.security.cognito;

import br.com.geniustest.api.model.User;
import br.com.geniustest.api.repository.UserRepository;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.proc.BadJOSEException;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Optional;

@Component
public class AwsCognitoIdTokenProcessor {

    @Autowired
    private AwsCognitoConfiguration awsCognitoConfiguration;

    @Autowired
    private ConfigurableJWTProcessor<SecurityContext> configurableJWTProcessor;

    private final UserRepository userRepository;

    public AwsCognitoIdTokenProcessor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Authentication authenticate(HttpServletRequest request) throws BadJOSEException, ParseException, JOSEException {
        String idToken = request.getHeader(this.awsCognitoConfiguration.getHttpHeader());

        if (idToken != null) {
            JWTClaimsSet claims = this.configurableJWTProcessor.process(this.getBearerToken(idToken), null);
            validateTokenUse(claims);
            validateIssuer(claims);
            validateAud(claims);

            String email = claims.getClaims().get(this.awsCognitoConfiguration.getEmailField()).toString();
            String username = claims.getClaims().get(this.awsCognitoConfiguration.getUserNameField()).toString();

            if (username != null && email != null) {

                Optional<User> user = userRepository.getUserByCognitoUsername(username);
                if (user.isEmpty()) throw new BadCredentialsException("User not founded on database");

                var userData = user.get();
                if (!userData.isEnabled()) throw new BadCredentialsException("User was not able to proceed with this request");

                return new AwsCognitoAuthenticationToken(userData, claims, idToken, user.get().getAuthorities());
            }
        }

        return null;
    }

    private void validateAud(JWTClaimsSet claims) {
        if (!claims.getAudience().contains(this.awsCognitoConfiguration.getWebClientId())) {
            throw new BadCredentialsException(String.format("Audience %s does not match expected aud", claims.getClaim("aud")));
        }
    }

    private void validateIssuer(JWTClaimsSet claims) {
        if (!claims.getIssuer().equals(this.awsCognitoConfiguration.getUserPoolUrl())) {
            throw new BadCredentialsException(String.format("Issuer %s does not match expected issuer", claims.getIssuer()));
        }
    }

    private void validateTokenUse(JWTClaimsSet claims) {
        if (!claims.getClaim("token_use").equals("id")) {
            throw new BadCredentialsException("JWT Token is not an ID Token");
        }
    }

    private String getBearerToken(String token) {
        return token.startsWith("Bearer ") ? token.substring("Bearer ".length()) : token;
    }
}
