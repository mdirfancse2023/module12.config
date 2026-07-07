package june.module5.homework.service;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private final String SECRET = "myverysecuresecretkeymyverysecuresecretkey12345";

    public String generateAccessToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 15
                        )
                )
                .signWith(
                        SignatureAlgorithm.HS256,
                        SECRET
                )
                .compact();
    }

    public String generateRefreshToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000L * 60 * 60 * 24 * 7
                        )
                )
                .signWith(
                        SignatureAlgorithm.HS256,
                        SECRET
                )
                .compact();
    }

    public String extractUsername(String token) {

        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isValid(String token) {

        try {

            Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token);

            return true;

        } catch (Exception e) {

            return false;
        }
    }
}
