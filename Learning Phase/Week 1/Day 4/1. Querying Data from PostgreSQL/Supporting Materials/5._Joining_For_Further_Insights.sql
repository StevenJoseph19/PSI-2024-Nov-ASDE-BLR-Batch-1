SELECT *
	FROM performance;

SELECT *
	FROM codes_cancellation;

SELECT *
	FROM codes_carrier;

SELECT p.fl_date,
	    p.mkt_carrier,
		p.mkt_carrier_fl_num AS flight,
		p.origin_city_name,
		p.dest_city_name
	FROM performance p;
-- INNER JOIN codes_carrier cc
-- 		ON p.mkt_carrier = cc.carrier_code;

SELECT p.fl_date,
	    p.mkt_carrier,
		cc.carrier_desc as airline,
		p.mkt_carrier_fl_num AS flight,
		p.origin_city_name,
		p.dest_city_name
	FROM performance p
INNER JOIN codes_carrier cc
		ON p.mkt_carrier = cc.carrier_code;

SELECT p.fl_date,
	    p.mkt_carrier,
		cc.carrier_desc as airline,
		p.mkt_carrier_fl_num AS flight,
		p.origin_city_name,
		p.dest_city_name,
		p.cancellation_code
	FROM performance p
INNER JOIN codes_carrier cc
		ON p.mkt_carrier = cc.carrier_code
	LEFT JOIN codes_cancellation ca 
			ON p.cancellation_code = ca.cancellation_code;

SELECT p.fl_date,
	    p.mkt_carrier,
		cc.carrier_desc as airline,
		p.mkt_carrier_fl_num AS flight,
		p.origin_city_name,
		p.dest_city_name,
		p.cancellation_code,
		ca.cancel_desc
	FROM performance p
INNER JOIN codes_carrier cc
		ON p.mkt_carrier = cc.carrier_code
	LEFT JOIN codes_cancellation ca 
			ON p.cancellation_code = ca.cancellation_code;
			


