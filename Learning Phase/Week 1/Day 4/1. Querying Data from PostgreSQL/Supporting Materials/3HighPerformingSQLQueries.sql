-- ========================================================================
-- Use Indexes Wisely
-- ========================================================================

CREATE INDEX idx_fl_date ON performance (fl_date);

-- ========================================================================
-- Limit the Number of Rows Returned
-- -- ========================================================================
SELECT fl_date, mkt_carrier, origin, dest FROM performance LIMIT 10;

-- ========================================================================
-- Use EXISTS Instead of IN for Subqueries

-- SELECT 1:
-- Instead of selecting specific columns from the table, it simply returns the constant 1 
-- for every row that meets the condition in the WHERE clause.
-- It is typically used when the actual data values from the rows are not needed, 
-- just the existence of rows is to be checked.

SELECT fl_date, mkt_carrier, origin, dest
FROM performance p
WHERE EXISTS (
  SELECT 1
  FROM codes_carrier c
  WHERE c.carrier_code = p.mkt_carrier
);

-- ===========================================================================
-- Filtering Early
-- ========================================================================

SELECT p.fl_date, p.mkt_carrier, c.carrier_desc, cc.cancel_desc, p.origin, p.dest
FROM performance p
JOIN codes_carrier c ON p.mkt_carrier = c.carrier_code
JOIN codes_cancellation cc ON p.cancellation_code = cc.cancellation_code
WHERE p.cancelled = 1;

-- ========================================================================
-- Index Usage
-- ========================================================================

CREATE INDEX idx_performance_mkt_carrier ON performance (mkt_carrier);
CREATE INDEX idx_performance_cancellation_code ON performance (cancellation_code);

-- =====================================================================
-- Optimized Query Example
-- =====================================================================

WITH FilteredPerformance AS (
  SELECT * FROM performance WHERE cancelled = 1
)
SELECT fp.fl_date, fp.mkt_carrier, c.carrier_desc, cc.cancel_desc, fp.origin, fp.dest
FROM FilteredPerformance fp
JOIN codes_carrier c ON fp.mkt_carrier = c.carrier_code
JOIN codes_cancellation cc ON fp.cancellation_code = cc.cancellation_code;

-- ======================================================================
-- Unoptimized Query Example
-- =====================================================================

SELECT p.fl_date, p.mkt_carrier, c.carrier_desc, cc.cancel_desc, p.origin, p.dest
FROM performance p
JOIN codes_carrier c ON p.mkt_carrier = c.carrier_code
JOIN codes_cancellation cc ON p.cancellation_code = cc.cancellation_code
WHERE p.cancelled = 1;

-- =====================================================================================


SELECT fl_date, mkt_carrier, origin, dest FROM performance;

-- ========================================================================

SELECT p.fl_date, p.mkt_carrier, c.carrier_desc, p.origin, p.dest
FROM performance p
INNER JOIN codes_carrier c ON p.mkt_carrier = c.carrier_code;

-- ========================================================================

WITH FlightDelays AS (
  SELECT fl_date, origin, dest, dep_delay_new, arr_delay_new
  FROM performance
  WHERE dep_delay_new IS NOT NULL OR arr_delay_new IS NOT NULL
)
SELECT * FROM FlightDelays WHERE dep_delay_new > 30;


-- ======================================================================

EXPLAIN SELECT * FROM performance WHERE dep_delay_new > 30;

EXPLAIN ANALYZE
SELECT fl_date, mkt_carrier, origin, dest
FROM performance
WHERE dep_delay_new > 30;

-- ======================================================================

SELECT * FROM performance WHERE TO_CHAR(fl_date, 'YYYY-MM-DD') = '2023-01-01'; -- Inefficient
SELECT * FROM performance WHERE fl_date = '2023-01-01'; -- Efficient

-- ======================================================================






