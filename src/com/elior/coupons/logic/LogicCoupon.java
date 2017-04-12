package com.elior.coupons.logic;

import com.elior.coupons.beans.Company;
import com.elior.coupons.beans.Coupon; 
import com.elior.coupons.dao.CouponDao;
import com.elior.coupons.enums.CouponType;
import com.elior.coupons.enums.ErrorType;
import com.elior.coupons.enums.TypeError;
import com.elior.coupons.exception.ApplicationException;
import com.elior.coupons.logic.interfaces.ILogicCoupon;
import com.elior.coupons.enums.TypeError;
//@@@@@@@@@@@@@@@@@
//
// author elior ish shalom
//
//#########################

public class LogicCoupon implements ILogicCoupon {
	//create coupon if exsit by tytle
	@Override
	public void createCoupon(Coupon coupon) throws ApplicationException{

		CouponDao couponDao = new CouponDao();

		if(couponDao.isCouponExistByTitle(coupon.getTitle())){
			throw new ApplicationException(ErrorType.COUPON_NAME_ALREADY_EXISTS, "Coupon already exists");
		}
		couponDao.createCoupon(coupon);
	}
	//remove the coupon if exist by id
	@Override
	public void removeCoupon(long id) throws ApplicationException{

		CouponDao couponDao = new CouponDao();

		if(!couponDao.isCouponExistById(id)){
			throw new ApplicationException(TypeError.GENERAL_ERROR,"coupon not exist!!!");
		}

		couponDao.removeCoupon(id);
	}
	//update coupon if exsite by id 
	@Override
	public void updateCoupon(Coupon coupon) throws ApplicationException{

		CouponDao couponDao = new CouponDao();

		if( ! couponDao.isCouponExistById(coupon.getId())){
			throw new ApplicationException(TypeError.GENERAL_ERROR,"can not uptate");
		}

		couponDao.updateCoupon(coupon);
	}
	//get coupon if exist by id
	@Override
	public Coupon getCoupon(long id) throws ApplicationException {

		CouponDao couponDao = new CouponDao();

		if( ! couponDao.isCouponExistById(id)){
			throw new ApplicationException(TypeError.GENERAL_ERROR, "coupon not exist");
		}

		return couponDao.getCoupon(id);


	}
}
