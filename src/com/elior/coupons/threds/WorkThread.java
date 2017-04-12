package com.elior.coupons.threds;

import com.elior.coupons.dao.CouponDao;
import com.elior.coupons.exception.ApplicationException; 


public class WorkThread implements Runnable {

	public void run(){

		try {
			CouponDao couponsDao = new CouponDao();
			couponsDao.removeOldCoupons();
		
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}
}
