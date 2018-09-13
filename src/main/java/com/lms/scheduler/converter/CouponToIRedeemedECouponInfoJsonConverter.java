package com.lms.scheduler.converter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.lms.scheduler.domain.Coupon;
import com.lms.scheduler.domain.IssuedECouponInfoJson;
import com.lms.scheduler.domain.RedeemedECouponInfoJson;

public class CouponToIRedeemedECouponInfoJsonConverter {
	public static ArrayList<RedeemedECouponInfoJson> convert( 
			List<Coupon> couponList ) { 
		ArrayList<RedeemedECouponInfoJson> jsonObjList = new ArrayList<RedeemedECouponInfoJson>();  
		//   
		for( Coupon c : couponList ) {
			RedeemedECouponInfoJson jsonObj = new RedeemedECouponInfoJson();
			ArrayList<RedeemedECouponInfoJson.RedeemInfo> couponDetailsInfoList = new ArrayList<RedeemedECouponInfoJson.RedeemInfo>();
			RedeemedECouponInfoJson.RedeemInfo details = new RedeemedECouponInfoJson.RedeemInfo(); 
			details.setCouponNo(c.getCouponId());
			couponDetailsInfoList.add(details);
			
			jsonObj.setRedeemInfo(couponDetailsInfoList);
			jsonObj.setMallId(Integer.toString(c.getMallId()));
			jsonObj.setShopId(Integer.toString(c.getShopId()));
			jsonObj.setRedeemAmount(Double.toString(c.getValueAmount()));
			jsonObj.setRedeemDate(new SimpleDateFormat("dd/MM/yyyy").format(c.getRedeemDate()));
			jsonObjList.add(jsonObj);
		}
		
		
		return jsonObjList;
	}
	
	
	public static RedeemedECouponInfoJson convert(Coupon c ) { 
		
		 RedeemedECouponInfoJson jsonObj = new RedeemedECouponInfoJson();
			ArrayList<RedeemedECouponInfoJson.RedeemInfo> couponDetailsInfoList = new ArrayList<RedeemedECouponInfoJson.RedeemInfo>();
			RedeemedECouponInfoJson.RedeemInfo details = new RedeemedECouponInfoJson.RedeemInfo(); 
			details.setCouponNo(c.getCouponId());
			couponDetailsInfoList.add(details);
			
			jsonObj.setRedeemInfo(couponDetailsInfoList);
			jsonObj.setMallId(Integer.toString(c.getMallId()));
			jsonObj.setShopId(Integer.toString(c.getShopId()));
			jsonObj.setRedeemAmount(Double.toString(c.getValueAmount()));
			jsonObj.setRedeemDate(new SimpleDateFormat("dd/MM/yyyy").format(c.getRedeemDate()));
		
		return jsonObj;
	}
	
	
}
