package com.elior.coupons.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 

import com.elior.coupons.beans.Coupon;
import com.elior.coupons.enums.CouponType;
import com.elior.coupons.exception.ApplicationException;
//using interface for orderd the coupon mtuds
public interface ICouponDao  {
	public Coupon extractCouponFromResultSet(ResultSet resultSet) throws SQLException;
	public void createCoupon(Coupon coupon) throws ApplicationException;
	public void removeCoupon(long id) throws ApplicationException;
	public void updateCoupon(Coupon coupon) throws ApplicationException;
	public Coupon getCoupon(long id) throws ApplicationException;
	public List<Coupon> getAllCoupon() throws ApplicationException;
	public Coupon getCouponByType(CouponType coupon) throws ApplicationException;
	public boolean isCouponExistByTitle(String title) throws ApplicationException;
	public void removeOldCoupons() throws ApplicationException ;
	boolean isCouponExistById(long id) throws ApplicationException;


}
