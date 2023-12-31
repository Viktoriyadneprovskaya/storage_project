package com.example.storage_project.config.security;

import com.example.storage_project.model.security.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class AuthenticationHandler implements AuthenticationSuccessHandler {
    SimpleUrlAuthenticationSuccessHandler userSuccessHandler = new SimpleUrlAuthenticationSuccessHandler("/employee_page");
    SimpleUrlAuthenticationSuccessHandler adminSuccessHandler = new SimpleUrlAuthenticationSuccessHandler("/admin");


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        SecurityUser principal = (SecurityUser) authentication.getPrincipal();
        for (GrantedAuthority grantedAuthority:authorities) {
            String authorityName = grantedAuthority.getAuthority();
            if (authorityName.equals("ADMIN")) {
//                adminSuccessHandler.setDefaultTargetUrl("/admin/"+ principal.getId() + "/" + principal.getUsername());
                adminSuccessHandler.setDefaultTargetUrl("/admin");
                this.adminSuccessHandler.onAuthenticationSuccess(request, response, authentication);
                return;
            }
        }

//        userSuccessHandler.setDefaultTargetUrl("/employee_page/"+ principal.getId() + "/" + principal.getUsername());
        userSuccessHandler.setDefaultTargetUrl("/employee_page");
        this.userSuccessHandler.onAuthenticationSuccess(request,response,authentication);
    }
    }

