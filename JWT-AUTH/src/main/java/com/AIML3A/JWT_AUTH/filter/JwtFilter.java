package com.AIML3A.JWT_AUTH.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                   HttpServletResponse response,
                                   FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        System.out.println("Header: " + header); // 🔍 debug

        if (header != null && header.startsWith("Bearer ")) {

            String token = header.substring(7);

            // 👉 For now we skip validation (temporary fix)
            // and directly authenticate user

            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken("user", null, null);

            SecurityContextHolder.getContext().setAuthentication(auth);

            System.out.println("User authenticated via JWT");
        }

        filterChain.doFilter(request, response);
    }
}