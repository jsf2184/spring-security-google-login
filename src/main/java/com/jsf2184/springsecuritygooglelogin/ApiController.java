package com.jsf2184.springsecuritygooglelogin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    public static Logger _log = LoggerFactory.getLogger(ApiController.class);


    public ApiController() {
    }


    @GetMapping("/user")
    public String user() {
        printPrincipal();
        String username = getUsername();
        String res = String.format("<h1>Welcome User %s</h1>", username);
        return res;

    }

    @GetMapping("/admin")
    public String admin() {
        printPrincipal();
        String username = getUsername();
        String res = String.format("<h1>Welcome Admin %s</h1>", username);
        return res;
    }

    @GetMapping("/playful")
    public String playful() {
        printPrincipal();
        String username = getUsername();
        String res = String.format("<h1>Welcome Playful %s</h1>", username);
        return res;
    }

    public void printPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        System.out.printf("principal = %s", principal.toString());

    }

    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
        final String username = oidcUser.getEmail();
        return username;
    }

}
