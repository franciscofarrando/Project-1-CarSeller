package com.example.CarSeller.Services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class JWTService {
    private static  final String SECRET="secreto123";

    public String generateToken(String username, String roles){
        return JWT.create()
                .withSubject(username)
                .withClaim("roles", roles)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis()+ 1000*60*60))
                .sign(Algorithm.HMAC256(SECRET));


    }
}
