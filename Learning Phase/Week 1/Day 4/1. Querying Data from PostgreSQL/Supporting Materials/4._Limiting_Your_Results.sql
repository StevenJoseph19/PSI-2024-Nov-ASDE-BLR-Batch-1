SELECT fl_date,
		mkt_carrier AS airline,
		mkt_carrier_fl_num AS flight,
		origin,
		dest
	FROM performance
WHERE origin = 'ORD';
-- WHERE dest = 'ORD';
	AND origin = 'BZN';

SELECT fl_date,
		mkt_carrier AS airline,
		mkt_carrier_fl_num AS flight,
		origin_city_name
	FROM performance
WHERE origin_city_name LIKE 'Fort%';

SELECT DISTINCT origin_city_name
	FROM performance
WHERE origin_city_name LIKE 'Fort%';

SELECT DISTINCT origin_city_name
	FROM performance
WHERE origin_city_name LIKE 'New%LA';

SELECT DISTINCT origin_city_name
	FROM performance
WHERE origin_city_name LIKE '____, KS';

SELECT DISTINCT origin_city_name
	FROM performance
WHERE origin_city_name LIKE '____,%';

SELECT fl_date,
		mkt_carrier AS airline,
		mkt_carrier_fl_num AS flight,
		cancellation_code
	FROM performance
WHERE cancellation_code IS NOT NULL;
-- WHERE cancellation_code IS NULL;


