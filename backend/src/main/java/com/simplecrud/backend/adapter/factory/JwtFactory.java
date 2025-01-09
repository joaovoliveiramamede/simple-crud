package com.simplecrud.backend.adapter.factory;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtFactory {
    
    private final SecretKey SIGNIN_KEY;
    private static final Long DEFAULT_EXPIRATION = 3000000000000L;

    public JwtFactory(@Value("${spring.jwt.secret}") String secretKey) {
        this.SIGNIN_KEY = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String createToken(Map<String, Object> claims, String subject) {
        String token = Jwts.builder()
            .claims(claims)
            .subject(subject)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + DEFAULT_EXPIRATION))
            .signWith(SIGNIN_KEY)
            .compact();
        return encryptToken(token);
    }

    private static String encryptToken(String token) {
        return Base64.getEncoder().encodeToString(token.getBytes());
    }

    private static String decryptToken(String token) {
        byte[] decoded = Base64.getDecoder().decode(token);
        return new String(decoded);
    }

    public Boolean validateToken(String token) {
        Jwts
            .parser()
            .verifyWith(SIGNIN_KEY)
            .build()
            .parseSignedClaims(decryptToken(token));
        return true;
    }

    public Claims extractClaims(String token) {
        return Jwts
            .parser()
            .verifyWith(SIGNIN_KEY)
            .build()
            .parseSignedClaims(decryptToken(token))
            .getPayload();
    }
}
