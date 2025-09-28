USE currencydb;
SELECT * FROM Currency;
SELECT * FROM Currency WHERE abbreviation = 'EUR';
SELECT COUNT(*) AS currency_count FROM Currency;
SELECT * FROM Currency ORDER BY rate_to_usd DESC LIMIT 1;