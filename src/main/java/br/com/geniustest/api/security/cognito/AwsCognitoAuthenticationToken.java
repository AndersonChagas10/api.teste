package br.com.geniustest.api.security.cognito;

import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

public class AwsCognitoAuthenticationToken extends AbstractAuthenticationToken {

    private final UserDetails userDetails;
    private final JWTClaimsSet jwtClaimsSet;
    private final String token;

    public AwsCognitoAuthenticationToken(UserDetails userDetails, JWTClaimsSet jwtClaimsSet, String token, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.userDetails = userDetails;
        this.jwtClaimsSet = jwtClaimsSet;
        this.token = token;
        super.setDetails(userDetails);
        super.setAuthenticated(true);
    }

    public Object getCredentials() {
        return null;
    }

    public Object getPrincipal() {
        return this.userDetails;
    }

    public JWTClaimsSet getJwtClaimsSet() {
        return this.jwtClaimsSet;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AwsCognitoAuthenticationToken that = (AwsCognitoAuthenticationToken) o;
        return userDetails.equals(that.userDetails) && jwtClaimsSet.equals(that.jwtClaimsSet) && token.equals(that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userDetails, jwtClaimsSet, token);
    }
}
