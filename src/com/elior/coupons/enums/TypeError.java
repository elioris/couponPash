package com.elior.coupons.enums;

public enum TypeError {
	CUSROMER_NAME_ALREADY_EXISTS(1),
	COUPON_NAME_ALREADY_EXISTS(2),
	INVALID_EMAIL(3),
	GENERAL_ERROR(4);
	
	private int internalErrorCode;
	TypeError(int internalErrorCode){
		this.internalErrorCode = internalErrorCode;
	}
	public int getInternalErrorCode(){
		return internalErrorCode;
	}

}
