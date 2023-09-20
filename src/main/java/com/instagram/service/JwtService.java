package com.instagram.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {

    public static  final String SECRET ="nQJ3ixBkWa0p4ww8Ek2aUIK2+g+vObSpI9OTmI1UMw3Z0Sbj3RIzrYW81T0mT+qEdgFqFu0i7PJBNy/uNDwgVZgNz07Wq12zCERjsAndZs6zYdFMTDNlZRENjl+OBdKvaRykQOx2IRW9jPfDqbj4i7ie9XXnT7EpVMaXfhnIJhqXM6tpB2JVIWceuaT4EDWWjFxbZwtBsqv757PazdBkvK6+CY6JsNFudEQfhzxGA0a53PDTCFzeF8fESow91uo053Wbar62OaxSpnVRZRDHMO6AWVOlw9GfBWX/JVGDLa9UIWSSORaeLgzmJMmHkao/DvthRYwYwN2ZiImKp/zfj0E5mO05iq6fdv3x/15XcOk=";


    public String extractUserName(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public  Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
         final Claims claims = extractAllClaims(token);
         return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build().parseClaimsJws(token)
                .getBody();
    }

    private  Boolean isTokenExpired(String token){
        return  extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final  String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String generateToken(String userName){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    private String createToken(Map<String, Object> claims, String userName) {
          return Jwts.builder()
                  .setClaims(claims)
                  .setSubject(userName)
                  .setIssuedAt(new Date(System.currentTimeMillis() ))
                  .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
                  .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte [] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
