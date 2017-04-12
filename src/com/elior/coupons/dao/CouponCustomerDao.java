package com.elior.coupons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.elior.coupons.beans.Company;
import com.elior.coupons.beans.Coupon;
import com.elior.coupons.beans.Customer;
import com.elior.coupons.beans.JoinCustomerCoupon;
import com.elior.coupons.enums.TypeError;
import com.elior.coupons.exception.ApplicationException;
import com.elior.coupons.utilss.JdbcUtils;

public class CouponCustomerDao implements IcouponCustomerDao{

	@Override
	//create coupon id and customer id where customer get coupon 
	public void createCustomerCoupon(JoinCustomerCoupon customerCoupon) throws ApplicationException {
		//coonection help as to connect to db
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("insert into join_cust_coupon (customer_ID,coupon_ID) values (?,?)");
			//getting the values
			preparedStatement.setLong(1,customerCoupon.getCustomerid());
			preparedStatement.setLong(2, customerCoupon.getCouponId());
			// execute The query
			preparedStatement.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR, e , "ca'nt create coupun" + e.getMessage());
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	@Override
	//show the coupon id and coustomer id
	public JoinCustomerCoupon getCustomerCoupon( long customerId) throws ApplicationException {
		//coonection help as to connect to db
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		JoinCustomerCoupon joinTable = null;
		try
		{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("select * from join_cust_coupon where customer_ID = ? ");
			//getting the values
			
			preparedStatement.setLong(1, customerId);
			// execute The query
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				joinTable = extractCouponFromResultSet(resultSet);
			}



		}catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR, e , "can't display coiupon" + e.getMessage());
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		System.out.println(joinTable);
		return joinTable;
	}

	@Override
	//delete one coustomer id and coupon id from join table only
	public void deleteCustomerCoupon(long id) throws ApplicationException {
		//coonection help as to connect to db
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try{
			// getting coonection from the linux server
			connection = JdbcUtils.getConnection();

			preparedStatement = connection.prepareStatement("delete from join_cust_coupon where coupon_ID = ? or customer_ID = ?");
			//getting the values
			preparedStatement.setLong(1, id);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR,e,"cn't delete coupon:" + e.getMessage());
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement);
		}

	}

	@Override
	//extract the SQL to bee able to print it
	public JoinCustomerCoupon extractCouponFromResultSet(ResultSet resultSet) throws SQLException{

		long couponId = resultSet.getLong("coupon_ID");
		long customerId = resultSet.getLong("customer_ID");

		JoinCustomerCoupon joinSQLTable = new JoinCustomerCoupon(couponId , customerId);
		return joinSQLTable;
	}

	@Override
	public boolean isCustomerCouponExistByCustomerId(long customerId)
			throws ApplicationException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try{
			
			// getting coonection from the linux server

			connection = JdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement("select * from join_cust_coupon where customer_ID = ?");
			//getting the values
			preparedStatement.setLong(1, customerId);
			
			// execute The query
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				return true;
			}

		}catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException(TypeError.GENERAL_ERROR, e, "dos not exist" + e.getMessage());
		}finally{
			JdbcUtils.closeResources(connection, preparedStatement, resultSet);
		}
		return false;
	}

	
		
	


}
