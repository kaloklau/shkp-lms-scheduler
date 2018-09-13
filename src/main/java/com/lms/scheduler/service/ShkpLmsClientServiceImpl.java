package com.lms.scheduler.service;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.lms.scheduler.domain.Coupon;
import com.lms.scheduler.domain.IssuedECouponInfoJson;
import com.lms.scheduler.domain.IssuedECouponLmsReplyJson;
import com.lms.scheduler.domain.RedeemedECouponInfoJson;
import com.lms.scheduler.domain.RedeemedECouponLmsReplyJson;
import com.lms.scheduler.converter.CouponToIRedeemedECouponInfoJsonConverter;
import com.lms.scheduler.converter.CouponToIssuedECouponInfoJsonConverter; 

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ShkpLmsClientServiceImpl implements ShkpLmsClientService {
	// TOOD : put to property files 
	private static final String SHK_LMS_REG_ISSUED_EGIFT_API_URI = "http://dev.kaishing.hk/mobile/liveeasy/hs/hs_mso_msg"; 
	private static final String SHK_LMS_REG_REDDEMED_EGIFT_API_URI = "http://dev.kaishing.hk/mobile/liveeasy/hs/hs_mso_msg2";
	private static final String SUB_SYSTEM_ID = "1"; 
	private static final String AUTHEN_KEY = "sdhfskdjhflsdfsdf";
	
	

	@Override
	public RedeemedECouponLmsReplyJson postRedeemECouponAPI(Coupon coupon) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		RedeemedECouponInfoJson postJsonObj = CouponToIRedeemedECouponInfoJsonConverter.convert(coupon);
		postJsonObj.setAuthenticationKey(AUTHEN_KEY);
		postJsonObj.setSubSystemId(SUB_SYSTEM_ID);
		
		ObjectMapper mapper = new ObjectMapper(); 
		
		String jsonSend = null;
		try {
			jsonSend = mapper.writeValueAsString(postJsonObj);
			System.out.println("json string is " + jsonSend);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ( jsonSend != null ) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(jsonSend,headers);
			
			String responseStr = restTemplate.postForObject( SHK_LMS_REG_REDDEMED_EGIFT_API_URI, entity ,String.class);
			if ( responseStr != null ) {
				try {
					RedeemedECouponLmsReplyJson replyJsonObj = mapper.readValue(responseStr, RedeemedECouponLmsReplyJson.class);
					return replyJsonObj;
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}
		} 
		return null;
	}
	
	@Override
	public IssuedECouponLmsReplyJson postIssuedECouponAPI( List<Coupon> couponList ) {
		 
		
		
		RestTemplate restTemplate = new RestTemplate();
		IssuedECouponInfoJson postJsonObj = CouponToIssuedECouponInfoJsonConverter.convert(couponList);
		postJsonObj.setAuthenticationKey(AUTHEN_KEY);
		postJsonObj.setCouponCount(Integer.toString(couponList.size()));
		postJsonObj.setSubSystemId(SUB_SYSTEM_ID);
		
		ObjectMapper mapper = new ObjectMapper(); 
		
		String jsonSend = null;
		try {
			jsonSend = mapper.writeValueAsString(postJsonObj);
			System.out.println("json string is " + jsonSend);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ( jsonSend != null ) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(jsonSend,headers);
			
			String responseStr = restTemplate.postForObject( SHK_LMS_REG_ISSUED_EGIFT_API_URI, entity ,String.class);
			if ( responseStr != null ) {
				try {
					IssuedECouponLmsReplyJson replyJsonObj = mapper.readValue(responseStr, IssuedECouponLmsReplyJson.class);
					return replyJsonObj;
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}
		} 
		
		return null;
	}


	
}




