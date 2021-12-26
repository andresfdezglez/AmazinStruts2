package com.miw.model;

public class LoginInfo {
	
	private String login = null;
	private String password = null;
	private String captcha = null;
	
	public LoginInfo() {
		super();
	}
	
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [login=" + login + ", password=" + password + "]";
	}
	
	
}
