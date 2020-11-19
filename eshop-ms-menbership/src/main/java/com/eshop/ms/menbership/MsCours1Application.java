package com.eshop.ms.menbership;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eshop.ms.menbership.model.User;
import com.eshop.ms.menbership.repository.UserRepository;
import com.eshop.ms.menbership.resource.UserResource;
import com.eshop.ms.menbership.security.JwTokenGenerator;
import com.eshop.ms.menbership.service.UserService;

@SpringBootApplication
public class MsCours1Application implements CommandLineRunner{
	
	@Autowired
	private JwTokenGenerator generator;
	private UserRepository userRepository = new UserRepository();
	private User user;
	private UserService userService;
	private UserResource userResource;
	
	public static void main(String[] args) {
		SpringApplication.run(MsCours1Application.class, args);
		
	}

	@Override
	public void run(String... args)throws Exception{
		//String token = generator.generateToken("Sympho", Arrays.asList("ADMIN"));
		//System.out.println(token);
		
		user = new User("symphoris@esipe.com", "sympho", 26, "admin");
		userService = new UserService();
		userRepository.addUser(user);
		
				
	}
}
