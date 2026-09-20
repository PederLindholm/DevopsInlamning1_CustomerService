INSERT INTO customer (name, email, tel)
SELECT 'Anna Andersson', 'anna@test.se', '0701234567'
    WHERE NOT EXISTS (SELECT 1 FROM customer WHERE email = 'anna@test.se');