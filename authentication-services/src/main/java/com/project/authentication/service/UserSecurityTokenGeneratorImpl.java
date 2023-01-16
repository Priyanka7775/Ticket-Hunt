package com.project.authentication.service;

import com.project.authentication.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
//component is defined as a class file that includes the @Service annotation and allows developers to add business functionalities.
public class UserSecurityTokenGeneratorImpl implements UserSecurityTokenGenerator {
    @Override
    public Map<String, String> tokenGenerator(User user) {

        Map<String,String> map = new HashMap<>();
        String jwtToken = Jwts.builder().setIssuer("myApp")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,"mysecret")
                .compact();
        Map<String,Object> map2 = new HashMap<>();
        map.put("token",jwtToken);
        map.put("userEmail", String.valueOf(user));
        map.put("Message","LoggedIn successfully");
        map2.put("user",user);
        return map;
    }
}
