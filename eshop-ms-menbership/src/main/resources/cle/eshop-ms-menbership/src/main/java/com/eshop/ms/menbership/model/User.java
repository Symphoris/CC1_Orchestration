package com.eshop.ms.menbership.model;

public class User {
	
	private String password;
	
	private String login;
	
	private int age;
	
	
	private String privillege;
	
	
	public User(String login, String password,  int age, String privillege) {
		this.password = password;
		this.login = login;
		this.age = age;
		this.privillege = privillege;
	}

	public String getPassword() {
		return password;
	}

	

	public String getPrivillege() {
		return privillege;
	}

	public void setPrivillege(String privillège) {
		this.privillege = privillège;
	}

	public void setPassword(String username) {
		this.password = username;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String email) {
		this.login = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [password=" + password + ", login=" + login + ", age=" + age + ", privillege=" + privillege + "]";
	}
	
	

}
