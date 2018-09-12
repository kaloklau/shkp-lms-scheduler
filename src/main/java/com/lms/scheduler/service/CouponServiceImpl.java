package com.lms.scheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.lms.scheduler.mapper.*;

@Component
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponMapper couponMapper;
	
}
