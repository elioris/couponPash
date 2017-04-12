package com.elior.coupons.logic;

import com.elior.coupons.beans.Customer;
import com.elior.coupons.dao.CustomerDao;
import com.elior.coupons.enums.TypeError;
import com.elior.coupons.exception.ApplicationException;
import com.elior.coupons.logic.interfaces.ILogicCustomer;

//=======================
//
//  author elior ish shalom
//
//==========================

public class LogicCustomer implements ILogicCustomer{
	
	//create new customeer if the id exist
	@Override
	public void createCustomer(Customer customer) throws ApplicationException{

		CustomerDao customerDao = new CustomerDao(); 
		
		if(customerDao.isCustomerExistById(customer.getId())){
			throw new ApplicationException(TypeError.GENERAL_ERROR,"customer alredy exist");
		}
		customerDao.createCustomer(customer);
	}
	//update customer if customer exist by id
	@Override
	public void updateCustomer(Customer customer) throws ApplicationException {

		CustomerDao customerDao = new CustomerDao();

		if( ! customerDao.isCustomerExistById(customer.getId())){
			throw new ApplicationException(TypeError.GENERAL_ERROR, "can not update");
		}
		customerDao.updateCustomer(customer);
	}
	//remove customer if exist by id
	@Override
	public void removeCustomer(long id) throws ApplicationException{

		CustomerDao customerDao = new CustomerDao();

		if( ! customerDao.isCustomerExistById(id)){

			throw new ApplicationException(TypeError.GENERAL_ERROR, "customer not remove");

		}
		customerDao.removeCustomer(id);
	}
	//login if username and password match
	@Override 
	public void login( String userName, String password , long id) throws ApplicationException{

		CustomerDao customerDao = new CustomerDao();

		if(!customerDao.login(userName, password , id)){
			throw new ApplicationException(TypeError.GENERAL_ERROR,"Error");
		}
		customerDao.getCustomer(id);
	}
	//if id exist show the customerr ditilse
	@Override
	public Customer getCustomer(long id) throws ApplicationException {

		CustomerDao customerDao = new CustomerDao();

		if( ! customerDao.isCustomerExistById(id)){
			throw new ApplicationException(TypeError.GENERAL_ERROR, "customer not exist");
		}

		return customerDao.getCustomer(id);

	}
}
