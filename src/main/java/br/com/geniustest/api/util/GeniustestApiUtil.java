package br.com.geniustest.api.util;

import br.com.geniustest.api.model.User;
import br.com.geniustest.api.security.cognito.AwsCognitoAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class GeniustestApiUtil {

    private GeniustestApiUtil() {
    }

    public static AwsCognitoAuthenticationToken getAuthentication() {
        return (AwsCognitoAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    }

    public static User getAuthenticatedUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
