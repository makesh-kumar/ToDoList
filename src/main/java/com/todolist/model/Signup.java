/**
 * 
 */
package com.todolist.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 *@author Makesh Kumar
 * 
 */
@Document(collection = "signup")
public class Signup {
	
	@Id
	private int signupid;
	
	private String userid;
	private String name;
	private String email;
	private String pass;
	private String conpass;
	public Signup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Signup(int signupid, String userid, String name, String email, String pass, String conpass) {
		super();
		this.signupid = signupid;
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.conpass = conpass;
	}


	public int getSignupid() {
		return signupid;
	}
	public void setSignupid(int signupid) {
		this.signupid = signupid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getConpass() {
		return conpass;
	}
	public void setConpass(String conpass) {
		this.conpass = conpass;
	}

	
	@Override
	public String toString() {
		return "Signup [signupid=" + signupid + ", userid=" + userid + ", name=" + name + ", email=" + email + ", pass="
				+ pass + ", conpass=" + conpass + "]";
	}
	
	
	
}
