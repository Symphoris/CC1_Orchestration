package com.eshop.ms.basket.security;

import java.security.interfaces.RSAPublicKey;
import java.time.Instant;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.eshop.ms.basket.model.Context;
import com.eshop.ms.basket.setting.InfraSettings;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

@Service
public class JwTokenValidator {
	
private JWSVerifier verifier;

public JwTokenValidator() {
	System.out.println("toto");
	verifier = new RSASSAVerifier((RSAPublicKey) InfraSettings.keyPairLoader().getPublic());
}
	
	@PostConstruct
	public void init() {
		
		
		
	}
	public Context transforme(String token) {
		System.out.println("titi");
		try {
			System.out.println(token);
			SignedJWT signedJwt = SignedJWT.parse(token);
			
			if(!signedJwt.verify(verifier)) {
				throw new RuntimeException("Invalid Token");
			}
			if (!validate(signedJwt.getJWTClaimsSet())) {
				throw new RuntimeException("Invalid Token");
			}
			Context usercontext = new Context();
			
			usercontext.setSubject(signedJwt.getJWTClaimsSet().getSubject());
			
			
			return usercontext;
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	private boolean validate(JWTClaimsSet claims) {
		return validateTokenExpiration(claims) && validateTokenIssuer(claims);
	}
	
	private boolean validateTokenExpiration(JWTClaimsSet claims) {
		return Instant.now().isBefore(claims.getExpirationTime().toInstant());
	}
	private boolean validateTokenIssuer(JWTClaimsSet claims) {
		return claims.getIssuer().equalsIgnoreCase("EPISEN.MEMBERSHIP") ? true : false;
	}
	
	

}
