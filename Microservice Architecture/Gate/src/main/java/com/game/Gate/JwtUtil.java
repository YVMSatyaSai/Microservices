package com.game.Gate;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.nio.charset.StandardCharsets;

@Component
public class JwtUtil {

    private final String SECRET = "mysecretkeymysecretkeymysecretkey123"; // 32+ chars

    private final Key SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(SECRET_KEY)
                .compact();
    }

    public String validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}