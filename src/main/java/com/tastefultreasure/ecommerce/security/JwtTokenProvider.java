package com.tastefultreasure.ecommerce.security;

import org.springframework.security.core.Authentication;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.tastefultreasure.ecommerce.exception.TasteFulTreasureException;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app-jwt-expiration-milliseconds}")
    private long jwtExpirationDate;
    
    // Getter for jwtSecret
    public String getJwtSecret() {
        return jwtSecret;
    }

    // Getter for jwtExpirationDate
    public long getJwtExpirationDate() {
        return jwtExpirationDate;
    }

    // generate JWT token
    public String generateToken(Authentication authentication){
        String username = authentication.getName();

        Date currentDate = new Date();

        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

        String token = Jwts.builder().
        		claims().and()
        		.subject(username)
        		.issuedAt(new Date())
        		.expiration(expireDate)
                .signWith(key())
                .compact();
        return token;
    }

    private Key key(){
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecret)
        );
    }

    // get username from Jwt token
    public String getUsername(String token){
    	Claims claims = Jwts.parser()
    	        .verifyWith((SecretKey) key())
    	        .build()
    	        .parseSignedClaims(token)
    	        .getPayload();
                 
        String username = claims.getSubject();
        return username;
    }

    // validate Jwt token
    public boolean validateToken(String token){
        try{
        	Jwts.parser()
        	        .verifyWith((SecretKey) key())
        	        .build()
        	        .parseSignedClaims(token)
        	        .getPayload();
            return true;
        } catch (MalformedJwtException ex) {
            throw new TasteFulTreasureException(HttpStatus.BAD_REQUEST, "Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            throw new TasteFulTreasureException(HttpStatus.BAD_REQUEST, "Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            throw new TasteFulTreasureException(HttpStatus.BAD_REQUEST, "Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            throw new TasteFulTreasureException(HttpStatus.BAD_REQUEST, "JWT claims string is empty.");
        }
    }
}

