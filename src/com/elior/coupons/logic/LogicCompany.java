package com.elior.coupons.logic;

import com.elior.coupons.beans.Company;
import com.elior.coupons.beans.JoinCustomerCoupon;
import com.elior.coupons.dao.CompanyDao;
import com.elior.coupons.dao.CouponCustomerDao;
import com.elior.coupons.enums.TypeError;
import com.elior.coupons.exception.ApplicationException;
import com.elior.coupons.logic.interfaces.ILogicCompany;
import com.elior.coupons.utilss.ValidationUtil;
//**********************(;
//autor elior ish shalom
//***********************

public class LogicCompany  implements ILogicCompany{
	ValidationUtil validation = new ValidationUtil ();
	CouponCustomerDao joinTable = new CouponCustomerDao () ;  

	@Override
	// chck if its pasible to create company 
	public  void createCompny (Company company) throws ApplicationException{

		CompanyDao companyDao = new CompanyDao();

		//chack if company is vild 
		if(companyDao.isCompanyExistByName(company.getCompanyName()) ){
			throw new ApplicationException(TypeError.GENERAL_ERROR, "company is exist");
			
		}
		else if (validation.isEmailValid(company.getEmail()) && validation.isPasswordValid(company.getPassword())){
		//going to dao and create in db 
		companyDao.createCompany(company);
		}
	}
	@Override
	public void removeCompany(long id) throws ApplicationException{

		CompanyDao companyDao = new CompanyDao();

		//chack by id and then remove
		if( ! companyDao.isCompanyExistById(id)){
			throw new ApplicationException(TypeError.GENERAL_ERROR,"company not exist");
		}
		//going to dao and remove in db 
		companyDao.removeCompany(id);
		joinTable.deleteCustomerCoupon(id);
	}

	@Override
	//update company only with exist id
	public void updateCompany(Company company)throws ApplicationException{

		
		CompanyDao companyDao = new CompanyDao();
		//chack if the company not exist
		if( ! companyDao.isCompanyExistById(company.getId())){
			throw new ApplicationException(TypeError.GENERAL_ERROR,"not allowd to update" );
		}else if (validation.isEmailValid(company.getEmail()) && validation.isPasswordValid(company.getPassword())){
		companyDao.updateCompany(company);
		}

	}
	@Override
	//if company is log in then show the the user the datils
	public void login( String companyName , String password, long id) throws ApplicationException{

		CompanyDao companyDao = new CompanyDao();
		//chack if the comany can accses to db
		
		if (validation.isPasswordValid(password)){
		}
		else if(!companyDao.login(companyName , password)){
			throw new ApplicationException(TypeError.GENERAL_ERROR,"rong user");
		}
		//going to dao and take information from the db 
		companyDao.getCompany(id);
	}
	@Override
	public Company getCompany(long id) throws ApplicationException {

		CompanyDao companyDao = new CompanyDao ();
		//chck id of compay
		if(! companyDao.isCompanyExistById(id)){
			throw new ApplicationException(TypeError.GENERAL_ERROR, "not exist..");
		}

		System.out.println(companyDao.getCompany(id));
		return companyDao.getCompany(id);

	}




}
