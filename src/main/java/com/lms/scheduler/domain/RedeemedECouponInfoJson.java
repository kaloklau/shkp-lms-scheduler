package com.lms.scheduler.domain;

import java.util.List;

public class RedeemedECouponInfoJson {
	private String subSystemId;
	private String authenticationKey; 
	private String mallId; 
	private String shopId; 
	private String redeemAmount;
	private String redeemDate; 
	private List<RedeemInfo> redeemInfo; 
	
	public String getSubSystemId() {
		return subSystemId;
	}

	public void setSubSystemId(String subSystemId) {
		this.subSystemId = subSystemId;
	}

	public String getAuthenticationKey() {
		return authenticationKey;
	}

	public void setAuthenticationKey(String authenticationKey) {
		this.authenticationKey = authenticationKey;
	}

	public String getMallId() {
		return mallId;
	}

	public void setMallId(String mallId) {
		this.mallId = mallId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getRedeemAmount() {
		return redeemAmount;
	}

	public void setRedeemAmount(String redeemAmount) {
		this.redeemAmount = redeemAmount;
	}

	public String getRedeemDate() {
		return redeemDate;
	}

	public void setRedeemDate(String redeemDate) {
		this.redeemDate = redeemDate;
	}

	public List<RedeemInfo> getRedeemInfo() {
		return redeemInfo;
	}

	public void setRedeemInfo(List<RedeemInfo> redeemInfo) {
		this.redeemInfo = redeemInfo;
	}

	public static class RedeemInfo {
		private String couponNo;

		public String getCouponNo() {
			return couponNo;
		}

		public void setCouponNo(String couponNo) {
			this.couponNo = couponNo;
		} 

	
	}
	
	
}
