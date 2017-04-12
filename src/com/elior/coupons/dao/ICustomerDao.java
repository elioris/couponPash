package com.elior.coupons.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 

import com.elior.coupons.beans.Company;
import com.elior.coupons.beans.Coupon;
import com.elior.coupons.beans.Customer;
import com.elior.coupons.exception.ApplicationException;
//using interface for orderd the customer mtuds
public interface ICustomerDao {
	public void createCustomer(Customer customer) throws ApplicationException;
	public void removeCustomer(long id) throws ApplicationException;
	public void updateCustomer(Customer customer) throws ApplicationException;
	public Customer getCustomer(long id) throws ApplicationException;
	public List<Customer> getAllCustomer() throws ApplicationException;
	public boolean login(String coustomerName,String password , long id) throws ApplicationException;
	public boolean isCustomerExistById(long id) throws ApplicationException;
	public Customer extractCustomerFromResultSet(ResultSet resultSet) throws SQLException;
}
