package com.lms.scheduler.domain;

import java.util.List;

public class IssuedECouponInfoJson {
	private String subSystemId;
	private String authenticationKey; 
	private String couponCount; 
	private List<ECouponDetails> couponInfo; 
	
	
	
	
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
	public String getCouponCount() {
		return couponCount;
	}
	public void setCouponCount(String couponCount) {
		this.couponCount = couponCount;
	}
	public List<ECouponDetails> getCouponInfo() {
		return couponInfo;
	}
	
	public void setCouponInfo(List<ECouponDetails> couponInfo) {
		this.couponInfo = couponInfo;
	}


	public static class ECouponDetails{
		String couponNo;
		String valueType;
		String expiryDate;
		String issueDate;
		public String getCouponNo() {
			return couponNo;
		}
		public void setCouponNo(String couponNo) {
			this.couponNo = couponNo;
		}
		public String getValueType() {
			return valueType;
		}
		public void setValueType(String valueType) {
			this.valueType = valueType;
		}
		public String getExpiryDate() {
			return expiryDate;
		}
		public void setExpiryDate(String expiryDate) {
			this.expiryDate = expiryDate;
		}
		public String getIssueDate() {
			return issueDate;
		}
		public void setIssueDate(String issueDate) {
			this.issueDate = issueDate;
		}
		
		
	}
}
