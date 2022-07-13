package br.com.geniustest.api;

import br.com.geniustest.api.security.cognito.AwsCognitoConfiguration;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.util.DefaultResourceRetriever;
import com.nimbusds.jose.util.ResourceRetriever;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class GeniustestApiApplication {

    @Autowired
    private AwsCognitoConfiguration awsCognitoConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(GeniustestApiApplication.class, args);
    }

    @Bean
    public ConfigurableJWTProcessor<SecurityContext> configurableJWTProcessor() throws MalformedURLException {
        ResourceRetriever resourceRetriever = new DefaultResourceRetriever(awsCognitoConfiguration.getConnectionTimeout(), awsCognitoConfiguration.getReadTimeout());
        URL jwkSetURL = new URL(awsCognitoConfiguration.getJwkUrl());
        JWKSource<SecurityContext> keySource = new RemoteJWKSet<>(jwkSetURL, resourceRetriever);
        ConfigurableJWTProcessor<SecurityContext> jwtProcessor = new DefaultJWTProcessor<>();
        JWSKeySelector<SecurityContext> keySelector = new JWSVerificationKeySelector<>(JWSAlgorithm.RS256, keySource);
        jwtProcessor.setJWSKeySelector(keySelector);
        return jwtProcessor;
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(false);
        loggingFilter.setIncludeHeaders(false);
        return loggingFilter;
    }

}
