package com.lms.scheduler.domain;

public class RedeemedECouponLmsReplyJson {
	private String claimId;
	private String claimNo; 
	private String message;
	
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	} 
	
	public boolean isSuccessResponse() {
		if( claimId != null && claimNo != null ) { 
			if ( claimId.length() > 0 && claimNo.length() > 0 ) {
				return true;
			}
		}
		return false;
	}
}
