package com.lms.scheduler.domain;

public class IssuedECouponLmsReplyJson {
	
	public enum APIEventType {
		SUCCESS("SUCCESS"), 
		FAIL("FAIL");
		
		private String value;
		
		APIEventType(String value ){
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
		
	}
	
	private String event;
	private String errorMessage;
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
