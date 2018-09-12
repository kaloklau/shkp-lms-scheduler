package com.lms.scheduler.domain;

import java.io.*;
import java.util.Date;

public class Coupon implements Serializable{
	
	private String couponId; 
	private Double valueAmount;	
	private Date expiryDate; 
	private Date usedDate;
	private Date redeemDate;
	private int mallId; 
	private int shopId;

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public Double getValueAmount() {
		return valueAmount;
	}

	public void setValueAmount(Double valueAmount) {
		this.valueAmount = valueAmount;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getUsedDate() {
		return usedDate;
	}

	public void setUsedDate(Date usedDate) {
		this.usedDate = usedDate;
	}

	public Date getRedeemDate() {
		return redeemDate;
	}

	public void setRedeemDate(Date redeemDate) {
		this.redeemDate = redeemDate;
	}

	public int getMallId() {
		return mallId;
	}

	public void setMallId(int mallId) {
		this.mallId = mallId;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	} 
	
	
	public void dumpDetails() {
		
		System.out.println("couponId : " + couponId );
		System.out.println("valueAmount : " + valueAmount );
		System.out.println("expiryDate : " + expiryDate );
		System.out.println("usedDate : " + usedDate );
		System.out.println("redeemDate : " + redeemDate );
		System.out.println("mallId : " + mallId );
		System.out.println("shopId : " + shopId );
	}
	
	
	
}
