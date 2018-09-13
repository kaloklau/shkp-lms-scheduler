package com.lms.scheduler.service;

import com.lms.scheduler.domain.IssuedECouponLmsReplyJson;
import com.lms.scheduler.domain.RedeemedECouponLmsReplyJson;

import java.util.List;
import com.lms.scheduler.domain.Coupon;
public interface ShkpLmsClientService {
	
	public IssuedECouponLmsReplyJson postIssuedECouponAPI( List<Coupon> couponList );
	
	public RedeemedECouponLmsReplyJson postRedeemECouponAPI( Coupon coupon );
}
