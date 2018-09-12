package com.lms.scheduler;

import com.lms.scheduler.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LmsScheduler {

	@Autowired
	private CouponService couponService;
	
	public void sendRedeemedCouponToLMS() {}
	
	public void sendUsedCouponToLMS() {}
}
