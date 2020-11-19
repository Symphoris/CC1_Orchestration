package com.eshop.ms.menbership.resource;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.ms.menbership.model.AuthenticationModel;
import com.eshop.ms.menbership.security.JwTokenGenerator;
import com.eshop.ms.menbership.service.UserService;

@RestController
@RequestMapping(value = "authenticate", produces = ("application/json"))
public class AuthenticateRessource {
	
	@Autowired
	private JwTokenGenerator jwtGenerator;
	
	private UserService service = new UserService();
	
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public Object authenticate(@RequestBody AuthenticationModel authModel) {
		
		if(!"".equals(authModel.getPassword()) && !StringUtils.isEmpty(authModel.getLogin())) {
			
			String token = jwtGenerator.generateToken(authModel.getLogin(), Arrays.asList("ADMIN", "Test"));
			 System.out.println(token);
			
			return " you have been authenticate you can now check your basket ";
			
		}
		return "User not found test";
	}
	
	@GetMapping("basket")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public Object requestPnier(@RequestBody AuthenticationModel authModel) {
		
		if(!"".equals(authModel.getPassword()) && !StringUtils.isEmpty(authModel.getLogin())) {
			
			String token = jwtGenerator.generateToken(authModel.getLogin(), Arrays.asList("ADMIN", "Test"));
			 System.out.println(token);
			
			return service.create(token);
			
		}
		return "User not found test";
	}
}