package com.elior.coupons.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.elior.coupons.dao.CouponDao;
import com.elior.coupons.enums.CouponType;
import com.elior.coupons.enums.ErrorType;
import com.elior.coupons.enums.TypeError;
import com.elior.coupons.exception.ApplicationException;
import com.elior.coupons.beans.Company;
import com.elior.coupons.beans.Coupon;
import com.elior.coupons.utilss.JdbcUtils;

public class CompanyDao implements ICompanyDao{


	@Override
	//craete new company in db 
	public void createCompany(Company company) throws ApplicationException {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("insert into company ( companyName, `PASSWORD`, EMAIL)values(?,?,?)");
			//getting the values
			//preparedStatement.setLong(1, company.getId());
			preparedStatement.setString(1, company.getCompanyName());
			preparedStatement.setString(2, company.getPassword());
			preparedStatement.setString(3, company.getEmail());
			// execute The query
			preparedStatement.executeUpdate();

		}
		catch(SQLException e){
			e.getStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}
		finally{
			JdbcUtils.closeResources(connection, preparedStatement);

		}

	}

	@Override
	//delete company from db
	public void removeCompany(long id) throws ApplicationException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		Connection connection =null;

		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("delete from company where companyID = ?");
			//getting the value
			preparedStatement.setLong(1, id);

			// execute The query
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.getStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}
	@Override
	//update company in db 
	public void updateCompany(Company company) throws ApplicationException {
		// TODO Auto-generated method stub
		Connection connection = null ;
		PreparedStatement preparedStatement = null ;

		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("UPDATE company SET `companyID` = ?, `companyName` = ?, `PASSWORD` = ?, `EMAIL` = ? WHERE `companyID` = ?;");
			//getting the values
			preparedStatement.setLong(1, company.getId());
			preparedStatement.setString(2, company.getCompanyName());
			preparedStatement.setString(3, company.getPassword());
			preparedStatement.setString(4, company.getEmail());
			preparedStatement.setLong(5, company.getId());
			// execute The query
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}
	@Override
	//print company by id
	public Company getCompany(long id) throws ApplicationException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		Company company = null;
		ResultSet resultSet = null;
		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("select * from Company where companyID = ?");
			//getting the values
			preparedStatement.setLong(1, id);
			// execute The query
			resultSet = preparedStatement.executeQuery();
			
			
			
			if(!resultSet.next()){
				return null;
			}
			
			company = extractCompanyFromResultSet(resultSet);
			
		}catch(SQLException e){
			e.getStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement,resultSet);
		}
		System.out.println(company);

		return company;
	}
	@Override
	//print all companys from db
	public List<Company> getAllCompanies() throws ApplicationException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Company company = null;	

		List<Company> allCompany = new ArrayList<>();
		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("select * from company");
			// execute The query
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				company = extractCompanyFromResultSet(resultSet);
				allCompany.add(company);
			}
		}catch(SQLException e){
			e.getStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return allCompany;
	}


	@Override
	//chack if company name and password match
	public boolean login(String companyName, String password) throws ApplicationException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet  = null;


		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("select * from company where companyName = ? and PASSWORD = ?");
			//getting the values
			preparedStatement.setString(1, companyName);
			preparedStatement.setString(2, password);
			// execute The query
			resultSet = preparedStatement.executeQuery();

			if(!resultSet.next()){
				return false;
			}



		}catch(SQLException e){
			e.getStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement);
		}
		return true;
	}
	//convert result from db to object thet can print on screen
	private Company extractCompanyFromResultSet(ResultSet resultSet) throws SQLException{
		long id = resultSet.getLong("companyID");
		String companyName = resultSet.getString("companyName");
		String password = resultSet.getString("PASSWORD");
		String email = resultSet.getString("EMAIL");
		Company company = new Company(id, companyName,password,email);
		return company;
	}
//Used for the purpose requested to whether the user can perform
	@Override
	public boolean isCompanyExistByName(String companyName) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatment = null;
		ResultSet resultSet = null;

		try{
			// getting coonection from the linux server

			connection = JdbcUtils.getConnection();

			preparedStatment = connection.prepareStatement("select * from company where companyName = ? ");
			//getting the values
			preparedStatment.setString(1, companyName);
			// execute The query
			resultSet = preparedStatment.executeQuery();

			if(resultSet.next()){
				return true;

			}

		}catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR, e , "alrady exist..." + e.getMessage());
		}finally{
			JdbcUtils.closeResources(connection, preparedStatment);
		}
		return false;
	}
//Used for the purpose requested to whether the user can perform
	@Override
	public boolean isCompanyExistById(long id) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("select * from company where companyId = ? ");
			//getting the values
			preparedStatement.setLong(1, id);
			// execute The query
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				return true;
			}


		}catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR, e , "not exist" + e.getMessage());
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return false;
	}





}
