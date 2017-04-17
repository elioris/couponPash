package com.elior.coupons.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.elior.coupons.exception.ApplicationException;
import com.elior.coupons.logic.LogicCompany;
import com.elior.coupons.logic.LogicCoupon;
import com.elior.coupons.logic.LogicCustomer;

@Path("/login")
public class LoginApi {
	
	LogicCustomer customer = new LogicCustomer ();
	LogicCompany company = new LogicCompany ();
	
	@POST
	public void customerLogin (String userName , String password , long id) throws ApplicationException{
		
		customer.login(userName, password, id);
		
	}
	
	@POST
	public void companyLogin (String companyName , String password , long id) throws ApplicationException {
		
		company.login(companyName, password, id);
		
	}

}
