package com.elior.coupons.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorBean {

	int errorMassage ;
	String errorCode ;
	public ErrorBean(int errorMassage, String errorCode) {
		super();
		this.errorMassage = errorMassage;
		this.errorCode = errorCode;
	}
	public int getErrorMassage() {
		return errorMassage;
	}
	public void setErrorMassage(int errorMassage) {
		this.errorMassage = errorMassage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	
	
}
