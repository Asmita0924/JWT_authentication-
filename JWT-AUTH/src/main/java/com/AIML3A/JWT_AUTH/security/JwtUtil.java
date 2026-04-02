package com.AIML3A.JWT_AUTH.security;

import java.util.Date;
import java.security.Key;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private static final Key secret =
            Keys.hmacShaKeyFor("myverysecuresecretkeymyverysecuresecretkey".getBytes());

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(secret, SignatureAlgorithm.HS256)   // ✅ Fixed: key first, algorithm second
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()                           // ✅ Fixed: parserBuilder() replaces parser()
                .setSigningKey(secret)                        // ✅ Fixed: called on builder, not parser
                .build()                                      // ✅ Added: required to build the parser
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}