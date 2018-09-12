package com.lms.scheduler.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lms.scheduler.domain.*;

public interface CouponMapper {
	/*
	private String couponId; 
	private Double valueAmount;	
	private Date expiryDate; 
	private Date usedDate;
	private Date redeemDate;
	private int mallId; 
	private int shopId;
	*/
	
	
	@Select( "SELECT crt.coupon_id AS couponId , crt.value_amount AS valueAmount , crt.expiry_date AS expiryDate, crt.used_mall_id AS mallId," 
	+ " crt.used_shop_id AS shopId , crt.used_datetime AS usedDate , crt.redeem_datetime AS redeemDate " 
	+ " FROM coupon_redemption_transaction crt"
	+ " WHERE crt.status = 'R'"  
	+ " AND crt.used_datetime is not NULL"  
	+ " AND ( crt.coupon_id NOT IN ( SELECT coupon_id FROM shk_coupon_sync ) OR crt.coupon_id IN ( SELECT  coupon_id FROM shk_coupon_sync WHERE issue_registered != 'Y' ) )" )  
	List<Coupon> getLMSUnregisteredUsedECoupon();
	
	

	@Select( "SELECT crt.coupon_id AS couponId , crt.value_amount AS valueAmount , crt.expiry_date AS expiryDate, crt.used_mall_id AS mallId," 
			+ " crt.used_shop_id AS shopId , crt.used_datetime AS usedDate , crt.redeem_datetime AS redeemDate " 
			+ " FROM coupon_redemption_transaction crt"
			+ " WHERE crt.status = 'R' "
			+ " AND crt.redeem_datetime is not NULL" 
			+ " AND crt.coupon_id IN ( SELECT coupon_id FROM shk_coupon_sync WHERE redeem_registered != 'Y' AND issue_registered = 'Y' )  ")
	List<Coupon> getLMSUnregisteredRedeemedECoupon();		
	
	@Insert(" INSERT INTO shk_coupon_sync (coupon_id,issue_registered,issue_reg_date,created_by,create_date)"
			+ " VALUES (#{couponId},'Y',NOW(),'0',NOW())"
			+ " ON DUPLICATE KEY UPDATE issue_reg_date = NOW(), issue_registered = 'Y' ")
	void setUsedECouponRegistered(Coupon coupon ); 
	
	@Update( "update shk_coupon_sync SET redeem_reg_date = NOW() , redeem_registered = 'Y' WHERE coupon_id = #{couponId}")
	void setRedeemECouponRegistered(Coupon coupon); 
	
	
	
}
