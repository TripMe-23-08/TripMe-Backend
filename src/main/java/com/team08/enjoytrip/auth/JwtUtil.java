package com.team08.enjoytrip.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil { //TODO:JWTUtil
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public String generateToken(String subject, long expiration){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims, subject,expiration);
    }
    private String createToken(Map<String,Object> claims, String subject, long expiration){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiryDate)//10시간
                .signWith(key).compact();
    }

    public Boolean validateToken(String token) {
        final String username = extractSubject(token);
        return !isTokenExpired(token);
    }

    public String extractSubject(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.claims();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
