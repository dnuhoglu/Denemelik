package com.denemelik.demo.config;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenProvider {
    //@Value("${denemelik.app.jwtSecret}")
    private String jwtSecret = "jwtPirSecretKey";

    //@Value("${denemelik.app.jwtExpiration}")
    private int jwtExpiration = 86400;

    public String generateRandomToken(String email) {
        /*StringBuilder token = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            double randDouble = Math.random() * 25;
            int randInt = (int) randDouble;
            token.append((char) (randInt + 97));
        }
        return token.toString();*/
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpiration*1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }



    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            System.out.println("Invalid JWT signature -> " +  e);
        } catch (MalformedJwtException e) {
            System.out.println("Invalid JWT token -> " +  e);
        } catch (ExpiredJwtException e) {
            System.out.println("Expired JWT token -> " +  e);
            //userService.deleteByToken(authToken);
        } catch (UnsupportedJwtException e) {
            System.out.println("Unsupported JWT token -> " +  e);
        } catch (IllegalArgumentException e) {
            System.out.println("JWT claims string is empty -> " +  e);
        }

        return false;
    }

    public String getEmailFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
}
