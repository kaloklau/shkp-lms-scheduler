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
	private String claimId; 
	private String claimNo;
	
	
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
	
	
	
	
	public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String dumpDetails() {
		StringBuffer sb = new StringBuffer(); 
		sb.append("couponId : " + couponId);
		sb.append("valueAmount : " + valueAmount );
		sb.append("usedDate : " + usedDate  );
		sb.append("expiryDate : " + expiryDate);
		sb.append("redeemDate : " + redeemDate);
		sb.append("mallId : " + mallId);
		sb.append("shopId : " + shopId );
		return sb.toString();
	}
	
	
	
}
