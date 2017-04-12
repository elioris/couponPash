package com.elior.coupons.beans;

import java.sql.ResultSet;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.elior.coupons.enums.CouponType;

//Taking the rows in tables and called in java and use get and set
@XmlRootElement
public class Coupon {
	
	private long id;
	private String title;
	private CouponType type;
	private String startDate;
	private String endDate;
	private int amount;
	private String message;
	private double price;
	private String image;
	
	
	//An empty constructor is needed to create a new instance via reflection
	
		public Coupon() {
		super();
	}

		public Coupon(String title, CouponType type, String startDate, String endDate, int amount, String message,
				double price, String image) {
			super();
			this.title = title;
			this.type = type;
			this.startDate = startDate;
			this.endDate = endDate;
			this.amount = amount;
			this.message = message;
			this.price = price;
			this.image = image;
		}

		public Coupon(long id, String title, CouponType type, String startDate, String endDate, int amount, String message,
			double price, String image) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.message = message;
		this.price = price;
		this.image = image;
	}
	
		public void setId(long id){
			this.id = id;
		}
		public long getId(){
			return id;
		}
		public void setTitle(String title){
			this.title = title;
		}
		public String getTitle(){
			return title;
		}
		public void setType(CouponType type){
			this.type = type;
		}
		public CouponType getType(){
			return type;
		}
	
		
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}

		@Override
		public String toString() {
			return "Coupon [id=" + id + ", title=" + title + ", type=" + type + ", startDate=" + startDate
					+ ", endDate=" + endDate + ", amount=" + amount + ", message=" + message + ", price=" + price
					+ ", image=" + image + "]";
		}

		
		
		
		
	
		
		}

