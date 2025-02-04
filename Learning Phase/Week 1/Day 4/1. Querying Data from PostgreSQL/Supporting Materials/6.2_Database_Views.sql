CREATE VIEW flight_info AS
SELECT p.fl_date, p.mkt_carrier, c.carrier_desc, p.origin, p.dest, p.dep_delay_new
FROM performance p
JOIN codes_carrier c ON p.mkt_carrier = c.carrier_code;

SELECT * FROM flight_info;

SELECT * FROM flight_info
WHERE dep_delay_new > 30;

-- ==========================================================================================

CREATE VIEW public_flight_info AS
SELECT fl_date, mkt_carrier, mkt_carrier_fl_num, origin, dest
FROM performance;

SELECT * FROM public_flight_info;

-- ==========================================================================================

CREATE VIEW delay_summary AS
SELECT fl_date, origin, dest, dep_delay_new, arr_delay_new
FROM performance
WHERE dep_delay_new IS NOT NULL OR arr_delay_new IS NOT NULL;

SELECT * FROM delay_summary;

-- ==========================================================================================

CREATE VIEW carrier_delay_summary AS
SELECT p.mkt_carrier, c.carrier_desc, AVG(p.dep_delay_new) AS avg_dep_delay, AVG(p.arr_delay_new) AS avg_arr_delay
FROM performance p
JOIN codes_carrier c ON p.mkt_carrier = c.carrier_code
GROUP BY p.mkt_carrier, c.carrier_desc;

SELECT * FROM carrier_delay_summary;

-- ==========================================================================================

CREATE VIEW cancellation_info AS
SELECT p.fl_date, p.mkt_carrier, p.mkt_carrier_fl_num, p.origin, p.dest, cc.cancel_desc
FROM performance p
JOIN codes_cancellation cc ON p.cancellation_code = cc.cancellation_code
WHERE p.cancelled = 1;

SELECT * FROM cancellation_info;

-- ==========================================================================================