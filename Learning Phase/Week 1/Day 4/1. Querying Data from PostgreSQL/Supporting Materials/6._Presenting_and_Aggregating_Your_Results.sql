SELECT AVG(dep_delay_new)
	FROM performance;

SELECT mkt_carrier,
		AVG(dep_delay_new)
	FROM performance
	GROUP BY mkt_carrier;

SELECT mkt_carrier,
		AVG(dep_delay_new)
	FROM performance p
INNER JOIN codes_carrier c
	ON p.mkt_carrier = c.carrier_code
	GROUP BY p.mkt_carrier,
			 c.carrier_desc;


SELECT p.mkt_carrier,
		c.carrier_desc,
		AVG(p.dep_delay_new)
	FROM performance p
INNER JOIN codes_carrier c
	ON p.mkt_carrier = c.carrier_code
	GROUP BY p.mkt_carrier,
			 c.carrier_desc
	 ORDER BY AVG(p.dep_delay_new);

SELECT p.mkt_carrier,
		c.carrier_desc,
		AVG(p.dep_delay_new) AS departure_delay,
		AVG(p.arr_delay_new) AS arrival_delay
	FROM performance p
INNER JOIN codes_carrier c
	ON p.mkt_carrier = c.carrier_code
	GROUP BY p.mkt_carrier,
			 c.carrier_desc
	ORDER BY AVG(p.dep_delay_new)DESC;
	-- ORDER BY 2;

SELECT p.mkt_carrier,
		c.carrier_desc,
		AVG(p.dep_delay_new) AS departure_delay,
		AVG(p.arr_delay_new) AS arrival_delay
	FROM performance p
INNER JOIN codes_carrier c
	ON p.mkt_carrier = c.carrier_code
	GROUP BY p.mkt_carrier,
			 c.carrier_desc
	 HAVING AVG(p.dep_delay_new) > 15
		AND AVG(p.arr_delay_new) > 15;





