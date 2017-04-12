package com.elior.coupons.beans;

import javax.xml.bind.annotation.XmlRootElement;

//Taking the rows in tables and called in java and use get and set
@XmlRootElement
public class JoinCustomerCoupon {

	private long customerid;

	private long couponId;

	public JoinCustomerCoupon(long customerid, long couponId) {
		super();
		this.customerid = customerid;
		this.couponId = couponId;
	}

	//An empty constructor is needed to create a new instance via reflection
	
	public JoinCustomerCoupon() {
		super();
	}

	@Override
	public String toString() {
		return "JoinCustomerCoupon [customerid=" + customerid + ", couponId=" + couponId + "]";
	}

	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public long getCouponId() {
		return couponId;
	}

	public void setCouponId(long couponId) {
		this.couponId = couponId;
	}



}
