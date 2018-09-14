package com.lms.scheduler;

import com.lms.scheduler.domain.Coupon;
import com.lms.scheduler.domain.IssuedECouponLmsReplyJson;
import com.lms.scheduler.domain.RedeemedECouponLmsReplyJson;
import com.lms.scheduler.service.*;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LmsScheduler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CouponService couponService;
	
	@Autowired 
	private ShkpLmsClientService shkLmsApiService; 
	
	//@Scheduled(fixedRate = 2000000)
	public void devTesting() {
		logger.info("running DEV test");
		sendUsedCouponToLMS();
		sendRedeemedCouponToLMS();
		
	}
	
	@Scheduled(cron="0 30 0 1,14 * *")
	public void sendRedeemedCouponToLMS() {
		logger.info("Scheduler running sendRedeemedCouponToLMS at " + new Date());
		List<Coupon> couponList = couponService.getLMSUnregisteredRedeemedECoupon(); 
		
		if ( couponList != null && couponList.size() != 0 ) {
			
			
			logger.info("Found redeemed coupon needed to be registered");
			
			for( Coupon c : couponList ) {
			
				RedeemedECouponLmsReplyJson replyJsonObj = shkLmsApiService.postRedeemECouponAPI(c);
				if ( replyJsonObj != null ) {
					if ( replyJsonObj.isSuccessResponse() ) { 
						c.setClaimId(replyJsonObj.getClaimId());
						c.setClaimNo(replyJsonObj.getClaimNo());
						couponService.setRedeemECouponRegistered(c);
					} else {
						logger.info("REDEEM REG-API return failed : " + replyJsonObj.getMessage() );
					} 
				}  else {
					logger.info("REDEEM REG-API com. failure"  );
				}
			} 
		}
		
		
	}
	
	
	@Scheduled(cron="0 0 0 1,14 * *")
	public void sendUsedCouponToLMS() {
		logger.info("Scheduler running sendUsedCouponToLMS at " + new Date() );
		
		
		List<Coupon> couponList = couponService.getLMSUnregisteredUsedECoupon();
		if ( couponList != null && couponList.size() != 0 ) {
			System.out.println("Found used coupon needed to be registered");
			IssuedECouponLmsReplyJson replyJsonObj = shkLmsApiService.postIssuedECouponAPI(couponList);
			if ( replyJsonObj != null && replyJsonObj.getEvent() != null ) {
				if ( replyJsonObj.getEvent().equals(IssuedECouponLmsReplyJson.APIEventType.SUCCESS.getValue()) ) {
					logger.info("Success in calling reg-use API, going to save success status to DB"); 
					for( Coupon c : couponList ) {
						couponService.setUsedECouponRegistered(c);
					}
				} else if (  replyJsonObj.getEvent().equals(IssuedECouponLmsReplyJson.APIEventType.FAIL.getValue()) ) {
					logger.info("API returns failure : " +  replyJsonObj.getErrorMessage() );
				} else {
					logger.info("unexpected error !" );
				}
			} 
		} else {
			logger.info("NO used coupon needed to be registered");
		}
		
		
	}
}
