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

import com.elior.coupons.beans.Company;
import com.elior.coupons.beans.Coupon;
import com.elior.coupons.exception.ApplicationException;
import com.elior.coupons.logic.LogicCoupon;

@Path("/coupon")
public class CouponApi {
	
	LogicCoupon coupon = new LogicCoupon();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createCoupon(Coupon Coupon) throws ApplicationException{
		
		coupon.createCoupon(Coupon);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCoupon (Coupon Coupon) throws ApplicationException{
		
		coupon.updateCoupon(Coupon);
		
	}
	
	@DELETE
	@Path("/{id}")
	public void removeCoupon(@PathParam("id") long id) throws ApplicationException{
		
		coupon.removeCoupon(id);
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{couponId}")
	public Coupon getCoupon(@PathParam("couponId") long id) throws ApplicationException{
		
		 return coupon.getCoupon(id);
		
	}
	
	

}
