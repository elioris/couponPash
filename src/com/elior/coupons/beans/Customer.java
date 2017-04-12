package com.elior.coupons.beans;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

//Taking the rows in tables and called in java and use get and set
@XmlRootElement
public class Customer {
	private long id;
	private String custName;
	private String password;
	
	



	//public Customer( String custname, String password) {
		//this.id = id;
//		this.cust_Name = custname;
//		this.password = password;
//	}
	
	
	
	public Customer(long id, String custName, String password) {
		super();
		this.custName = custName;
		this.password = password;
		this.id = id;
	}



	//An empty constructor is needed to create a new instance via reflection
	
	public Customer() {
		super();
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", password=" + password 
				+ "]";
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public  String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public  String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
