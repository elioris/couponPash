package com.elior.coupons.logic.interfaces;

import com.elior.coupons.beans.Coupon;
import com.elior.coupons.exception.ApplicationException;
//using interface for orderd the coupon mtuds
public interface ILogicCoupon {
	
	public void createCoupon(Coupon coupon) throws ApplicationException;
	
	public void removeCoupon(long id) throws ApplicationException;
	
	public void updateCoupon(Coupon id) throws ApplicationException;
	
	public Coupon getCoupon(long id) throws ApplicationException;

}
