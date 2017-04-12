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
	// delete join row from db if customer and coupon exist
	//public void deleteCustomerCoupon(long customerId, long couponId) throws ApplicationException{

		//CouponCustomerDao couponCustomerDao = new CouponCustomerDao();
		//CouponDao couponDao = new CouponDao();
		//CustomerDao customerDao = new CustomerDao();

		//if( ! couponCustomerDao.isCustomerCouponExistByCustomerIdAndCouponId(customerId, couponId)){
		//	throw new ApplicationException(TypeError.GENERAL_ERROR, "not delete");
	//	}

	//	couponCustomerDao.deleteCustomerCoupon(couponId, customerId);
	//	couponDao.removeCoupon(couponId);
	//	customerDao.removeCustomer(customerId);
	//}
	//print the  datils of customercoupon if the id of bowt exist
	public JoinCustomerCoupon getCustomerCoupon( long customerId) throws ApplicationException{

		CouponCustomerDao couponCustomerDao = new CouponCustomerDao();

		if( ! couponCustomerDao.isCustomerCouponExistByCustomerId(customerId)){
			throw new ApplicationException(TypeError.GENERAL_ERROR, "coupon not exist");
		}

		return couponCustomerDao.getCustomerCoupon( customerId);

	}




}
