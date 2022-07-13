package br.com.geniustest.api.security.cognito;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aws.cognito")
public class AwsCognitoConfiguration {
    private String userPoolId;
    private String webClientId;
    private String jwkUrl;
    private String region = "us-east-1";
    private String emailField = "email";
    private String userNameField = "cognito:username";
    private String httpHeader = "Authorization";
    private int readTimeout = 2000;
    private int connectionTimeout = 2000;

    public String getJwkUrl() {
        return this.jwkUrl != null && !this.jwkUrl.isEmpty()
                ? this.jwkUrl
                : String.format("https://cognito-idp.%s.amazonaws.com/%s/.well-known/jwks.json", this.region, this.userPoolId);
    }

    public String getUserPoolUrl() {
        return String.format("https://cognito-idp.%s.amazonaws.com/%s", this.region, this.userPoolId);
    }

    public String getUserPoolId() {
        return userPoolId;
    }

    public void setUserPoolId(String userPoolId) {
        this.userPoolId = userPoolId;
    }

    public String getWebClientId() {
        return webClientId;
    }

    public void setWebClientId(String webClientId) {
        this.webClientId = webClientId;
    }

    public void setJwkUrl(String jwkUrl) {
        this.jwkUrl = jwkUrl;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUserNameField() {
        return userNameField;
    }

    public void setUserNameField(String userNameField) {
        this.userNameField = userNameField;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public String getHttpHeader() {
        return httpHeader;
    }

    public void setHttpHeader(String httpHeader) {
        this.httpHeader = httpHeader;
    }

    public String getEmailField() {
        return emailField;
    }

    public void setEmailField(String emailField) {
        this.emailField = emailField;
    }
}
