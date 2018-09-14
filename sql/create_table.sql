create TABLE shk_coupon_sync (
	coupon_id varchar(15) NOT NULL, 
	issue_registered varchar(1) DEFAULT 'N', 
	redeem_registered varchar(1) DEFAULT 'N',
	issue_reg_date datetime, 
	redeem_reg_date datetime, 
	created_by varchar(20), 
	create_date datetime,
	claim_id varchar(50), 
	claim_no varchar(50),
	PRIMARY KEY (coupon_id)
);

///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
================================================================================================
Useful for testing first API in DEV environment :  
delete FROM coupon_redemption_transaction;

delete FROM shk_coupon_sync; 

INSERT INTO coupon_redemption_transaction (
coupon_redemption_transaction_id, 
expiry_date,                      
redeem_datetime,                  
redeem_type,                      
status,                           
used_datetime,                    
coupon_id,                        
used_mall_id,                     
used_shop_id,                     
redeem_bonus_points,              
value_amount) VALUES 
('AA0000000',NOW(),NOW()-20000,'R','R',NOW()-30000,'CC0000000',123,456,111,300);

================================================
When you want to test the second API : also type the following. 

INSERT INTO shk_coupon_sync (
coupon_id,        
issue_registered,
redeem_registered,
issue_reg_date,   
redeem_reg_date,  
created_by,       
create_date ) VALUES 
('CC0000000','Y','N',NOW(),NULL,NULL,NULL);
================================================