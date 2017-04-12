package com.elior.coupons.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.elior.coupons.beans.Company;
import com.elior.coupons.beans.Coupon;
import com.elior.coupons.beans.Customer ;
import com.elior.coupons.enums.TypeError;
import com.elior.coupons.exception.ApplicationException;
import com.elior.coupons.utilss.JdbcUtils;

public class CustomerDao implements ICustomerDao{

	@Override
	//call to create Coustomer in db use sql
	public void createCustomer(Customer customer) throws ApplicationException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("insert into coupons_manager.customer (ID,custName,password) values (?,?,?)");
			//getting the values
			preparedStatement.setLong(1, customer.getId());
			preparedStatement.setString(2, customer.getCustName());
			preparedStatement.setString(3, customer.getPassword());
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
	//remove cousomer from db 
	public void removeCustomer(long id) throws ApplicationException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection(); 
			preparedStatement = connection.prepareStatement("delete from customer where ID = ?");
			//getting permater from the user to sql
			preparedStatement.setLong(1, id);
			//excute sql qury
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.getStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	@Override
	//update coustomer in db 
	public void updateCustomer(Customer customer) throws ApplicationException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		Connection connection = null;

		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("update coupons_manager.customer set  custName = ?, password = ? where ID = ?");
			//getting permater from the user to sql
			preparedStatement.setString(1, customer.getCustName());
			preparedStatement.setString(2, customer.getPassword());
			preparedStatement.setLong(3, customer.getId());
			//excute sql qury
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.getStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement);
		}
	}

	@Override
	//print coustomer by id 
	public Customer getCustomer(long id) throws ApplicationException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Customer customer = null;
		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("select * from customer where ID = ?");
			//getting permater from the user to sql
			preparedStatement.setLong(1, id);
			//excute sql qury
			resultSet = preparedStatement.executeQuery();
			if(!resultSet.next()){
				return null;
			}
			customer = extractCustomerFromResultSet(resultSet);
		}catch(SQLException e){
			e.getStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		System.out.println(customer);
		return customer;

	}

	@Override
	//print all coustomer in db 
	public List<Customer> getAllCustomer() throws ApplicationException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Customer custo = null;
		//preper list to get the list of coustomers
		List<Customer> allCusto = new ArrayList<>();
		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("select * from customer");
			//excute sql qury
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				custo = extractCustomerFromResultSet(resultSet);
				allCusto.add(custo);
			}
		}catch(SQLException e){
			e.getStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return allCusto;
	}

	@Override
	//chack if the cousromer name and password exisiting in db 
	public boolean login(String customerName, String password , long id) throws ApplicationException {
		// TODO Auto-generated method stub
		PreparedStatement  preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Customer customer = null;

		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("select * from customer where custName = ? and password = ? and ID = ?");
			//getting permater from the user to sql
			preparedStatement.setString(1, customerName);
			preparedStatement.setString(2, password);
			preparedStatement.setLong(3, id);
			//excute sql qury
			resultSet = preparedStatement.executeQuery();
			if(!resultSet.next())
				return false;
			customer = extractCustomerFromResultSet(resultSet);
		}catch(SQLException e){
			e.getStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return true;
	}
	//convert the result from the sql to printable format
	public Customer extractCustomerFromResultSet(ResultSet resultSet) throws SQLException{
		long id = resultSet.getLong("ID");
		String custName = resultSet.getString("custName");
		String password = resultSet.getString("password");
		Customer customer = new Customer(id, custName,password);
		return customer;
	}

	@Override
	public boolean isCustomerExistById(long id) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			
			preparedStatement = connection.prepareStatement("select * from customer where id = ?");
			//getting permater from the user to sql
			preparedStatement.setLong(1, id);
			//excute sql qury
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				return true;
			}

		}catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR, "not exist");
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return false;
	}

}