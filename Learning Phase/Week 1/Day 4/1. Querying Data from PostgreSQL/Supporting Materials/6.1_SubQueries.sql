SELECT carrier_desc
FROM codes_carrier
WHERE carrier_code = (
  SELECT mkt_carrier
  FROM performance
  WHERE mkt_carrier_fl_num = '2427'
  LIMIT 1
);

-- ======================================================================================================
SELECT fl_date, mkt_carrier, mkt_carrier_fl_num, origin, dest
FROM performance
WHERE cancellation_code IN (
  SELECT cancellation_code
  FROM codes_cancellation
  WHERE cancel_desc = 'Carrier'
);

-- ======================================================================================================

SELECT fl_date, mkt_carrier, mkt_carrier_fl_num, origin, dest, dep_delay_new
FROM performance p1
WHERE dep_delay_new > (
  SELECT AVG(dep_delay_new)
  FROM performance p2
  WHERE p2.dest = p1.dest
);
-- ======================================================================================================

WITH AvgDelays AS (
  SELECT dest, AVG(dep_delay_new) AS avg_delay
  FROM performance
  GROUP BY dest
)
SELECT p1.fl_date, p1.mkt_carrier, p1.mkt_carrier_fl_num, p1.origin, p1.dest, p1.dep_delay_new
FROM performance p1
JOIN AvgDelays a ON p1.dest = a.dest
WHERE p1.dep_delay_new > a.avg_delay;
-- ======================================================================================================