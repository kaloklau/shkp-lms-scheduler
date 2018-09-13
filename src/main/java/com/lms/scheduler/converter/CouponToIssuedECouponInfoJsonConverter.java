package com.lms.scheduler.converter;

import com.lms.scheduler.domain.IssuedECouponInfoJson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.lms.scheduler.domain.Coupon;

public class CouponToIssuedECouponInfoJsonConverter {
	public static IssuedECouponInfoJson convert( 
			List<Coupon> couponList ) { 
		IssuedECouponInfoJson jsonObj = new IssuedECouponInfoJson();  
		ArrayList<IssuedECouponInfoJson.ECouponDetails> couponDetailsInfoList = new ArrayList<IssuedECouponInfoJson.ECouponDetails>();  
		for( Coupon c : couponList ) {
			IssuedECouponInfoJson.ECouponDetails details = new IssuedECouponInfoJson.ECouponDetails(); 
			details.setCouponNo(c.getCouponId());
			details.setExpiryDate(new SimpleDateFormat("dd/MM/yyyy").format(c.getExpiryDate()));
			details.setIssueDate(new SimpleDateFormat("dd/MM/yyyy").format(c.getUsedDate()));
			details.setValueType(Double.toString(c.getValueAmount()));
			couponDetailsInfoList.add(details); 
		}
		jsonObj.setCouponCount(Integer.toString(couponList.size()));
		jsonObj.setCouponInfo(couponDetailsInfoList);
		return jsonObj;
	}
	
	
}
