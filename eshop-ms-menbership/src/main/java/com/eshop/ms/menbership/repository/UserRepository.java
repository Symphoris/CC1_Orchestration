package com.eshop.ms.menbership.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.eshop.ms.menbership.model.User;

@Component
public class UserRepository {

	private static Map<String, User> userInMemory = new HashMap<>();
	
	
	
	public static void  addUser(User user){
		System.out.println("AddUser : username " + user.getLogin());
		
		userInMemory.put(user.getLogin(), user);
		//System.out.println(userInMemory.get("sympho").toString());
	}
	
	public User getUserByUsername(String login){
		System.out.println("getUserByUsername , username : " + login);
		return (User)userInMemory.get(login);
		
	}
	
	public List<User> getAll(){
		return new ArrayList<User>(userInMemory.values());
	}
	
	public void updateUser(User user){
		System.out.println("updateUser : userbame " + user.getPassword());
		userInMemory.put(user.getPassword(), user);
	}
	
	public void deleteUserByUsername(String login){
		System.out.println("deleteUserByUsername , username : " + login);
		userInMemory.remove(login);
	}
}
