package com.lms.scheduler;

import com.lms.scheduler.domain.Coupon;
import com.lms.scheduler.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LmsScheduler {

	@Autowired
	private CouponService couponService;
	
	@Scheduled(cron="0 0 * * * *")
	public void sendRedeemedCouponToLMS() {
		System.out.println("Anderson scheduler running 2222");
	}
	
	
	public void sendUsedCouponToLMS() {
		System.out.println("Anderson scheduler running 444");
		
		/*
		List<Coupon> couponList = couponService.getLMSUnregisteredRedeemedECoupon();
		if ( couponList != null ) {
			for( Coupon c : couponList ) {
				c.dumpDetails();
			}
		}
		*/
		Coupon c = new Coupon();
		c.setCouponId("CC0000001");
		couponService.setRedeemECouponRegistered(c);
	}
}
