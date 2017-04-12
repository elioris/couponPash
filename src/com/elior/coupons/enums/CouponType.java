package com.elior.coupons.enums;

public enum CouponType {
	HOLIDAY("Holiday"),
	RESTURANTS("RESTURANTS"), 
	ENTERTAINMENT("Entertainment"),
	TRAVELLING("Travelling");
	
	private String name;
		
	CouponType(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}	
}
