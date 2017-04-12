package com.elior.coupons.logic.interfaces;

import com.elior.coupons.beans.Company;
import com.elior.coupons.exception.ApplicationException;
//using interface for orderd the company mtuds 
public interface ILogicCompany {
	
	public void createCompny (Company company) throws ApplicationException;
	
	public void removeCompany(long id) throws ApplicationException;
	
	public void updateCompany(Company company)throws ApplicationException;
	
	public void login(String password ,String companyName , long id) throws ApplicationException;

	public Company getCompany(long id) throws ApplicationException;
}
