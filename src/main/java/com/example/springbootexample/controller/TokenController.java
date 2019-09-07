package com.example.springbootexample.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootexample.service.TokenService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

@RestController
@RequestMapping("/token")
public class TokenController {

	TokenService service = new TokenService();
	
	@RequestMapping(value = "/issue", method = RequestMethod.POST)
	public ResponseEntity<String> issueToken(@RequestBody Map<String, Object> payload) {
		return ResponseEntity.ok(this.service.issueToken(payload));
	}
	
	@RequestMapping(value = "/decode", method = RequestMethod.GET) 
	public ResponseEntity<Object> decodeToken(@RequestHeader("Authorization") String token) throws ExpiredJwtException, SignatureException{
		try {
			return ResponseEntity.ok(this.service.decodeToken(token.replace("Bearer", "").trim()));
		} catch(ExpiredJwtException e) {
			return ResponseEntity.ok(e.getClaims());
		} catch (SignatureException e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
}
