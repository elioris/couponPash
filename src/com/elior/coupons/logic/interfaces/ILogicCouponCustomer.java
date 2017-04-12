package com.elior.coupons.logic.interfaces;

import com.elior.coupons.beans.JoinCustomerCoupon;
import com.elior.coupons.exception.ApplicationException;
//using interface for orderd the couponcustomer mtuds
public interface ILogicCouponCustomer {


	public void createCustomerCoupon(JoinCustomerCoupon customerCoupon) throws ApplicationException;

	public void deleteCustomerCoupon(long customerId, long couponId) throws ApplicationException;

	public void getCustomerCoupon( long couponId , long customerId) throws ApplicationException;




}
