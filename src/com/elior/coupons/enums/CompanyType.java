package com.elior.coupons.enums;

public enum CompanyType {
	
	ADMIN("admin"),
	USER("user");

	private String typeName ; 
	
	CompanyType(String typeName){
		
		this.typeName = typeName;
		
	}
	
	public String getTypeName(){
		
		return typeName ;
		
	}
	
}
