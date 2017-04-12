package com.elior.coupons.logic.interfaces;

import com.elior.coupons.beans.Customer;
import com.elior.coupons.exception.ApplicationException;
//using interface for orderd the customer mtuds
public interface ILogicCustomer {

	public void createCustomer(Customer customer) throws ApplicationException;
	
	public void updateCustomer(Customer customer) throws ApplicationException;
	
	public void removeCustomer(long id) throws ApplicationException;
	
	public void login( String userName, String password , long id) throws ApplicationException;
	
	public Customer getCustomer(long id) throws ApplicationException;
	
	
}
