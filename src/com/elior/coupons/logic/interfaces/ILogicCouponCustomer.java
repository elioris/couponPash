package com.elior.coupons.logic.interfaces;

import com.elior.coupons.beans.JoinCustomerCoupon;
import com.elior.coupons.exception.ApplicationException;
//using interface for orderd the couponcustomer mtuds
public interface ILogicCouponCustomer {


	public void createCustomerCoupon(JoinCustomerCoupon customerCoupon) throws ApplicationException;

	public JoinCustomerCoupon getCustomerCoupon(  long customerId) throws ApplicationException;




}
