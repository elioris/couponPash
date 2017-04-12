package com.elior.coupons.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;




//Taking the rows in tables and called in java and use get and set

@XmlRootElement
public class Company {



	private long id;
	private String companyName;
	private String password;
	private String email;


	public Company(String companyName, String password, String email) {
		super();
		this.companyName = companyName;
		this.password = password;
		this.email = email;

	}



	public Company(long id, String companyName, String password, String email) {
		super();
		this.id = id;
		this.companyName= companyName;
		this.password = password;
		this.email = email;
	}

	
	//An empty constructor is needed to create a new instance via reflection
	
	public Company(){
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}





	@Override
	public String toString() {
		return "Company [id=" + id + ", compName=" + companyName + ", password=" + password + ", email=" + email
				+ "]";
	}
	public  String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



}
