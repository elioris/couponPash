package com.elior.coupons.dao;

import java.util.List;

import com.elior.coupons.beans.Company;
import com.elior.coupons.beans.Coupon;
import com.elior.coupons.enums.CouponType;
import com.elior.coupons.exception.ApplicationException;


//using interface for orderd the company mtuds

public interface ICompanyDao {
	public void createCompany(Company company) throws ApplicationException;
	public void removeCompany(long id) throws ApplicationException;
	public void updateCompany(Company company) throws ApplicationException;
	public Company getCompany(long id) throws ApplicationException;
	public List<Company> getAllCompanies() throws ApplicationException;
	public boolean login(String companyName, String password) throws ApplicationException;
	public boolean isCompanyExistByName(String companyName) throws ApplicationException;
	public boolean isCompanyExistById(long id) throws ApplicationException;
}
