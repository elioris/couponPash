package com.elior.coupons.logic;

import com.elior.coupons.beans.JoinCustomerCoupon;
import com.elior.coupons.dao.CouponCustomerDao;
import com.elior.coupons.dao.CouponDao;
import com.elior.coupons.dao.CustomerDao;
import com.elior.coupons.enums.TypeError;
import com.elior.coupons.exception.ApplicationException;
import com.elior.coupons.logic.interfaces.ILogicCouponCustomer;
//************************
//
// elior ish shalom
//
//************************

public class LogicCouponCustomer implements ILogicCouponCustomer{

	//create new row in table join if coupon exist and customer exist
	public void createCustomerCoupon(JoinCustomerCoupon customerCoupon) throws ApplicationException{

		CouponCustomerDao couponCustomerDao = new CouponCustomerDao();

		if(couponCustomerDao.isCustomerCouponExistByCustomerId(customerCoupon.getCustomerid())){
			throw new ApplicationException(TypeError.GENERAL_ERROR,"customerCoupon not created");
		}
		if( ! couponCustomerDao.isCustomerCouponExistByCustomerId(customerCoupon.getCustomerid())){
		couponCustomerDao.createCustomerCoupon(customerCoupon);
		}
	}
	
	public JoinCustomerCoupon getCustomerCoupon( long customerId) throws ApplicationException{

		CouponCustomerDao couponCustomerDao = new CouponCustomerDao();

		if( ! couponCustomerDao.isCustomerCouponExistByCustomerId(customerId)){
			throw new ApplicationException(TypeError.GENERAL_ERROR, "coupon not exist");
		}

		return couponCustomerDao.getCustomerCoupon( customerId);

	}




}
