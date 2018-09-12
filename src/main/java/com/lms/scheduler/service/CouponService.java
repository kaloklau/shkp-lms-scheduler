package com.lms.scheduler.service;

import java.util.List;

import com.lms.scheduler.domain.Coupon;

public interface CouponService {
	public List<Coupon> getLMSUnregisteredUsedECoupon();
	
	public List<Coupon> getLMSUnregisteredRedeemedECoupon();
	
	public void setUsedECouponRegistered(Coupon coupon);
	
	public void setRedeemECouponRegistered(Coupon coupon);
}
