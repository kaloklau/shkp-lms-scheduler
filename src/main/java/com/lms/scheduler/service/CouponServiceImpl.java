package com.lms.scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.scheduler.domain.Coupon;
import com.lms.scheduler.mapper.*;

@Component
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponMapper couponMapper;

	public List<Coupon> getLMSUnregisteredUsedECoupon(){
		List<Coupon> couponList = couponMapper.getLMSUnregisteredUsedECoupon(); 
		return couponList;
	}
	
	public List<Coupon> getLMSUnregisteredRedeemedECoupon(){
		List<Coupon> couponList = couponMapper.getLMSUnregisteredRedeemedECoupon(); 
		return couponList;
	}
	
	public void setUsedECouponRegistered(Coupon coupon) {
		couponMapper.setUsedECouponRegistered(coupon);
	}
	
	public void setRedeemECouponRegistered(Coupon coupon) {
		couponMapper.setRedeemECouponRegistered(coupon);
	}
}
