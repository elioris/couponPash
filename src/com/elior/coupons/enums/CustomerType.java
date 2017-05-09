package com.elior.coupons.enums;

public enum CustomerType {

	ADMIN(1),
	USER(2) ;
	
	private int number;
	
  CustomerType(int number){
		
		this.number = number;
		
	}
	
	public int getNumber(){
		
		return number;
		
	}
	
	
}
