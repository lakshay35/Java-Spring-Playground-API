package com.example.springbootexample.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;



@Service
public class TokenService {

	private static final String SECRET = "sa7tdgas7dgaisudgadgasdasdadg";
	
	public String issueToken(Map<String, Object> payload) {
		Map<String, Object> temp = new HashMap<String, Object>();
		temp.put("payload", payload);
		
		return Jwts.builder()
				.setClaims(temp)
				.setSubject("token")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 18000000))
				.signWith(SignatureAlgorithm.HS256, SECRET)
				.compact();
				

	}
	
	public Map<String, Object> decodeToken(String token) throws ExpiredJwtException, SignatureException{
		return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
	}

}
