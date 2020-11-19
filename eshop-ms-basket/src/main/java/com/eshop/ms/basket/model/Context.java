package com.eshop.ms.basket.model;

import java.util.List;

public class Context {
	
	private String subject;
	private List<String> authorities;
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public List<String> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
	@Override
	public String toString() {
		return "Context [subject=" + subject + ", authorities=" + authorities + "]";
	}
	

}
