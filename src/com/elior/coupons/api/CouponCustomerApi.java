package com.elior.coupons.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.elior.coupons.beans.JoinCustomerCoupon;
import com.elior.coupons.exception.ApplicationException;
import com.elior.coupons.logic.LogicCouponCustomer;

@Path("/CouponCustomer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class CouponCustomerApi {
	
	
	LogicCouponCustomer joinTableCustomer = new LogicCouponCustomer();
	
	@POST
	public void createCustomerCoupon(JoinCustomerCoupon customerCoupon) throws ApplicationException{
		
		
		joinTableCustomer.createCustomerCoupon(customerCoupon);
		
	}
	
	@DELETE
	@Path("/{customerCoupon}")
	public void deleteCouponCustomer(@PathParam ("customerCouon") long customerId , long couponId) throws ApplicationException{
		
		joinTableCustomer.deleteCustomerCoupon(customerId, couponId);
		
	}
	
	//@GET
	//@Path("/{customerCoupon}")
	//public JoinCustomerCoupon getCustomerCoupon (){
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
