package com.elior.coupons.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.elior.coupons.beans.Company;
import com.elior.coupons.beans.Coupon;
import com.elior.coupons.beans.Customer;
import com.elior.coupons.beans.JoinCustomerCoupon;
import com.elior.coupons.exception.ApplicationException;

//using interface for orderd the couponcustomer mtuds

public interface IcouponCustomerDao {
	
	public void deleteCustomerCoupon(long id) throws ApplicationException;

	public void createCustomerCoupon(JoinCustomerCoupon customerCoupon) throws ApplicationException;

	public  JoinCustomerCoupon getCustomerCoupon( long customerId) throws ApplicationException;
	
	public boolean isCustomerCouponExistByCustomerId(long customerId) throws ApplicationException;
	
	public JoinCustomerCoupon extractCouponFromResultSet(ResultSet resultSet) throws SQLException;
	

}
