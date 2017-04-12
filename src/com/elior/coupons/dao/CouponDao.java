package com.elior.coupons.dao;

import  com.elior.coupons.utilss.JdbcUtils;

import java.util.ArrayList;
import java.util.List;

import com.elior.coupons.exception.ApplicationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.elior.coupons.beans.Coupon;
import com.elior.coupons.dao.ICouponDao;
import com.elior.coupons.enums.CouponType;
import com.elior.coupons.enums.ErrorType;
import com.elior.coupons.enums.TypeError;
import com.elior.coupons.beans.Coupon;

public  class CouponDao implements ICouponDao {

	@Override
	//create coupon in db
	public void createCoupon (Coupon coupon) throws ApplicationException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement =null;
		Connection connection = null;
		try
		{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("insert into coupon (title, START_DATE,end_date,amount,type,message,price,image) values (?,?,?,?,?,?,?,?)");
			//getting the values
			//preparedStatement.setLong(1, coupon.getId());
			preparedStatement.setString(1, coupon.getTitle());
			preparedStatement.setString(2, coupon.getStartDate());
			preparedStatement.setString(3,coupon.getEndDate());
			preparedStatement.setInt(4,coupon.getAmount());
			preparedStatement.setString(5, coupon.getType().getName());
			preparedStatement.setString(6, coupon.getMessage());
			preparedStatement.setDouble(7, coupon.getPrice());
			preparedStatement.setString(8, coupon.getImage());
			preparedStatement.executeUpdate();

		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR, e, "Filed to create coupon due to :" + e.getMessage());
		}
		finally
		{
			JdbcUtils.closeResources(connection, preparedStatement );
		}	
	}
	//delete coupon from db by id
	public void removeCoupon(long id) throws ApplicationException {
		// TODO Auto-generated method stub
		PreparedStatement  preparedStatement = null;
		Connection connection = null;

		try
		{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("delete  from coupon where ID = ?");
			//getting the values
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}finally{
			JdbcUtils.closeResources(connection,preparedStatement);
		}

	}

	@Override
	//update coupon in db 
	public void updateCoupon (Coupon coupon ) throws ApplicationException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE coupon set title = ?, START_DATE = ?,end_date = ?, amount = ?, type = ?, message = ?,price = ?,image = ? where ID = ?");
			//getting the values
			//preparedStatement.setLong(1, coupon.getId());
			preparedStatement.setString(1, coupon.getTitle());
			preparedStatement.setString(2, coupon.getStartDate());
			preparedStatement.setString(3, coupon.getEndDate());
			preparedStatement.setInt(4, coupon.getAmount());
			preparedStatement.setString(5, coupon.getType().getName());
			preparedStatement.setString(6, coupon.getMessage());
			preparedStatement.setDouble(7, coupon.getPrice());
			preparedStatement.setString(8, coupon.getImage());
			preparedStatement.setLong(9, coupon.getId());

			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}
		finally{
			JdbcUtils.closeResources(connection, preparedStatement);

		}
	}

	@Override
	//print coupon by id
	public Coupon getCoupon(long id) throws ApplicationException{
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Coupon coupon =null;

		try {
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("select * from coupon where ID = ?");
			//getting the values
			preparedStatement.setLong(1, id);

			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				coupon = extractCouponFromResultSet(resultSet);
			}
		}catch (SQLException e){
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		System.out.println(coupon);
		return coupon;
	}


	@Override
	//print all coupons in db
	public List<Coupon> getAllCoupon() throws ApplicationException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Coupon coupon =null;

		List<Coupon> couponList = new ArrayList<Coupon>();

		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("select * from coupon");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				coupon = extractCouponFromResultSet(resultSet);
				couponList.add(coupon);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement,resultSet);
		}
		System.out.println(couponList);
		return couponList;
	}

	@Override
	//print coupun from db by is type
	public Coupon getCouponByType(CouponType type) throws ApplicationException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Coupon account = null;


		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("select * from coupon where type = ?");
			//getting the values
			preparedStatement.setString(1,type.getName());

			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				account = extractCouponFromResultSet(resultSet);
				System.out.println(account);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement,resultSet);
		}

		return account;
	}
	//Used for the purpose requested to whether the user can perform
	public boolean isCouponExistByTitle(long id) throws ApplicationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;		
		ResultSet resultSet = null;
		


		try {
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("select * from coupon where title = ?");
			//getting the values
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			// If there's something in the resultSet (I have at least 1 answer)
			if (resultSet.next()){
				return true;

			}	

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"filed to create coupon du to:" + e.getMessage() );
		} finally 
		{
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return false;
	}

	@Override
	//take the results from db in convert them to object to use them
	public Coupon extractCouponFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		long id = resultSet.getLong("id");
		String title = resultSet.getString("title");
		CouponType type = CouponType.valueOf(resultSet.getString("type"));
		String startDate = resultSet.getString("start_date");
		String endDate = resultSet.getString("end_date");
		int amount = resultSet.getInt("amount");
		String massage = resultSet.getString("message");
		double price = resultSet.getDouble("price");
		String image = resultSet.getString("image");
		Coupon coupon = new Coupon(id, title,type,startDate, endDate,amount , massage,price,image);
		return coupon;

	}
	//Used for the purpose requested to whether the user can perform
	@Override
	public boolean isCouponExistById(long id) throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("select * from coupon where ID = ?");

			preparedStatement.setLong(1,id);

			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				return true; 
			}

		}catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e, "not vild" + e.getMessage());
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}

		return false;
	}
	//thred use this to delete old coupon
	@Override
	public void removeOldCoupons() throws ApplicationException {
		
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try 

		{

			// Getting a connection from the connections manager (getConnection is a static method)

			connection = JdbcUtils.getConnection();

			//creating the SQL query

			preparedStatement = connection.prepareStatement("DELETE s, r FROM coupons s"

					+ " LEFT JOIN join_cust_coupon r "

					+ "ON s.COUPON_ID = r.coupon_ID WHERE s.END_DATE <= NOW()");

			preparedStatement.executeUpdate();

		} 
		catch (SQLException e) 

		{

			throw new ApplicationException(TypeError.GENERAL_ERROR, e, "Failed to get due to :" + e.getMessage());

		} 

		finally 

		{

			JdbcUtils.closeResources(connection, preparedStatement);

		}

		

	}
	@Override
	public boolean isCouponExistByTitle(String title) throws ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}
		
	

		
	}


