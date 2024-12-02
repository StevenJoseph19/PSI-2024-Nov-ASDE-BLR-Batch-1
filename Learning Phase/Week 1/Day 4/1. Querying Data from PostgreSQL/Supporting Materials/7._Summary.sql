SELECT fl_date,
		mkt_carrier,
		mkt_carrier_fl_num,
		origin,
		origin_city_name,
		dep_delay_new
	FROM performance
	WHERE origin = 'OMA';

SELECT   p.fl_date,
		 p.mkt_carrier,
		 c.carrier_desc,
		 p.mkt_carrier_fl_num,
		 p.origin,
		 p.origin_city_name,
		 p.dep_delay_new
	FROM performance p
INNER JOIN codes_carrier c
		ON p.mkt_carrier = c.carrier_code
	WHERE  p.origin = 'OMA';

SELECT AVG(dep_delay_new) AS average_delay
	FROM performance
	WHERE origin = 'OMA';

SELECT AVG(dep_delay_new) AS average_delay
	FROM performance
	WHERE origin = 'OMA'
		AND dep_delay_new <> 0;

SELECT p.mkt_carrier,
		c.carrier_desc,
		AVG(dep_delay_new) AS average_delay
	FROM performance p
INNER JOIN codes_carrier c
		ON p.mkt_carrier = c.carrier_code
	WHERE origin = 'OMA'
		AND dep_delay_new <> 0
	GROUP BY p.mkt_carrier,
			  c.carrier_desc;

SELECT p.mkt_carrier,
		c.carrier_desc,
		AVG(dep_delay_new) AS average_delay
	FROM performance p
INNER JOIN codes_carrier c
		ON p.mkt_carrier = c.carrier_code
	WHERE p.origin = 'OMA'
		AND p.dep_delay_new <> 0
	GROUP BY p.mkt_carrier,
			  c.carrier_desc
     ORDER BY AVG(p.dep_delay_new);

SELECT p.mkt_carrier,
		c.carrier_desc,
		AVG(dep_delay_new) AS average_delay
	FROM performance p
INNER JOIN codes_carrier c
		ON p.mkt_carrier = c.carrier_code
	WHERE p.origin = 'OMA'
		AND p.dep_delay_new <> 0
	GROUP BY p.mkt_carrier,
			  c.carrier_desc
    HAVING AVG( p.dep_delay_new) > 49
	ORDER BY AVG( p.dep_delay_new);