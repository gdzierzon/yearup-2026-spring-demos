SELECT * FROM northwind.Transactions;

-- For each month and country, show:
-- - number of transactions
-- - total amount of all transactions
-- - nr of approved transactions
-- - total amount of approved transactions

-- step 1: checkout out the data
SELECT * FROM Transactions;

-- step 2: what columns do I need?
SELECT country, state, amount, trans_date FROM Transactions;

-- step 3 (ty omar): get the month from the date
SELECT DATE_FORMAT(trans_date, '%Y-%m') AS month, country, state, amount FROM Transactions;

-- step 4: Group by month and country
SELECT DATE_FORMAT(trans_date, '%Y-%m') AS month, country FROM Transactions 
GROUP BY DATE_FORMAT(trans_date, '%Y-%m'), country;

-- step 5: Count transactions
SELECT DATE_FORMAT(trans_date, '%Y-%m') AS month, 
	country, 
    COUNT(*) AS nr_of_trans 
FROM Transactions 
GROUP BY DATE_FORMAT(trans_date, '%Y-%m'), country;

-- step 6: sum the transaction amounts
SELECT DATE_FORMAT(trans_date, '%Y-%m') AS month, 
	country, 
    COUNT(*) AS trans_count, 
    SUM(amount) AS total_trans_amount 
FROM Transactions GROUP BY DATE_FORMAT(trans_date, '%Y-%m'), country;

-- step 7: count approved transactions
SELECT 
    DATE_FORMAT(trans_date, '%Y-%m') AS month,
    country,
    COUNT(*) AS trans_count,
	SUM(amount) AS trans_total_amount,
    SUM(
        CASE 
            WHEN state = 'approved' THEN 1
            ELSE 0
        END
    ) AS approved_nr_of_trans
FROM Transactions
GROUP BY DATE_FORMAT(trans_date, '%Y-%m'), country;

-- step 8: sum only approved amounts
SELECT 
    DATE_FORMAT(trans_date, '%Y-%m') AS month,
    country,
    COUNT(*) AS trans_count,
	SUM(amount) AS trans_total_amount,
    SUM(
        CASE 
            WHEN state = 'approved' THEN 1
            ELSE 0
        END
    ) AS approved_nr_of_trans,
    SUM( 
		CASE 
			WHEN state = 'approved' THEN amount 
            ELSE 0 
		END 
	) AS approved_trans_total_amount
FROM Transactions
GROUP BY DATE_FORMAT(trans_date, '%Y-%m'), country;
