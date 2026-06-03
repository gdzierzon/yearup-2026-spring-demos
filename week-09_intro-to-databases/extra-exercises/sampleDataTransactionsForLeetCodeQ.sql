DROP TABLE IF EXISTS Transactions;

CREATE TABLE Transactions (
    id INT PRIMARY KEY,
    country VARCHAR(10),
    state ENUM('approved', 'declined'),
    amount INT,
    trans_date DATE
);

INSERT INTO Transactions (id, country, state, amount, trans_date) VALUES
-- December 2018
(1, 'US', 'approved', 1000, '2018-12-18'),
(2, 'US', 'declined', 2000, '2018-12-19'),
(3, 'DE', 'approved', 1500, '2018-12-20'),

-- January 2019
(4, 'US', 'approved', 2000, '2019-01-01'),
(5, 'US', 'approved', 3000, '2019-01-05'),
(6, 'US', 'declined', 500, '2019-01-07'),
(7, 'DE', 'approved', 2000, '2019-01-08'),
(8, 'DE', 'declined', 1000, '2019-01-09'),
(9, 'FR', 'approved', 700, '2019-01-15'),

-- February 2019
(10, 'US', 'declined', 1200, '2019-02-01'),
(11, 'US', 'declined', 800, '2019-02-03'),
(12, 'DE', 'approved', 2500, '2019-02-10'),
(13, 'DE', 'approved', 1000, '2019-02-11'),
(14, 'FR', 'declined', 900, '2019-02-12'),
(15, 'FR', 'approved', 1100, '2019-02-13'),

-- March 2019
(16, 'US', 'approved', 4000, '2019-03-01'),
(17, 'US', 'approved', 1500, '2019-03-02'),
(18, 'US', 'declined', 600, '2019-03-03'),
(19, 'DE', 'declined', 1300, '2019-03-04'),
(20, 'FR', 'approved', 2200, '2019-03-05'),
(21, 'FR', 'approved', 1800, '2019-03-06'),
(22, 'FR', 'declined', 700, '2019-03-07'),

-- April 2019
(23, 'US', 'approved', 900, '2019-04-01'),
(24, 'DE', 'approved', 3000, '2019-04-02'),
(25, 'DE', 'declined', 500, '2019-04-03'),
(26, 'FR', 'declined', 1200, '2019-04-04'),
(27, 'FR', 'declined', 800, '2019-04-05');