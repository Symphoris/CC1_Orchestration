package com.eshop.ms.menbership.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eshop.ms.menbership.model.AuthenticationModel;
import com.eshop.ms.menbership.model.JwToken;
import com.eshop.ms.menbership.model.Panier;
import com.eshop.ms.menbership.model.User;
import com.eshop.ms.menbership.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	private RestTemplate restTemplate = new RestTemplate();

	public void addUser(User user){
		if("".equals(user.getPassword()) || "".equals(user.getLogin()) || "".equals(user.getPrivillege())){
			throw new RuntimeException("user exception");
		}
		else if (!(user.getPrivillege().equals("admin"))) {
			throw new RuntimeException("cannot create user, you are not an admin");
		}
		else {
		repository.addUser(user);
		}
	}
	
	public User getUser(String login){
		
		User user = repository.getUserByUsername(login);
		System.out.println(login + "test");
		
		if(user == null){
			throw new RuntimeException("User not found");
		}
		
		return user;
	}
	
	public List<User> getAll(){
		return repository.getAll();
	}
	
	public void updateUser(String login, User user){
		
		if(repository.getUserByUsername(login) == null){
			throw new RuntimeException("User not found");
		}
		
		repository.updateUser(user);
	}
	
	public void deleteUser(String login){
		
		if(repository.getUserByUsername(login) == null){
			throw new RuntimeException("User not found");
		}
		
		repository.deleteUserByUsername(login);
	}

	public UserRepository getRepository() {
		return repository;
	}

	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}
	

    public Panier create(String token){
        ResponseEntity<Panier> response =
                restTemplate.postForEntity(
                        "http://localhost:8090/episen/api/v1/products/validate",
                        token, Panier.class);
        
        return response.getBody();
    }
	
	
}
