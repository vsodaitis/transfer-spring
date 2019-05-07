INSERT INTO user_entity (id, full_name) VALUES (NEXT VALUE FOR hibernate_sequence, 'Viktor Tsoy');

INSERT INTO balance_entity (id, total, reserved) VALUES (NEXT VALUE FOR hibernate_sequence, 100, 90);
INSERT INTO balance_entity (id, total, reserved) VALUES (NEXT VALUE FOR hibernate_sequence, 600, 11);

INSERT INTO account_entity (id, user_id, status, balance_id, iban, currency) VALUES (NEXT VALUE FOR hibernate_sequence, 1, 'ACTIVE', 2, 'LT4645464564', 'EUR');
INSERT INTO account_entity (id, user_id, status, balance_id, iban, currency) VALUES (NEXT VALUE FOR hibernate_sequence, 1, 'ACTIVE', 3, 'RB3151564887', 'USD');

INSERT INTO user_entity (id, full_name) Values (NEXT VALUE FOR hibernate_sequence, 'John Smith');

INSERT INTO balance_entity (id, total, reserved) VALUES (NEXT VALUE FOR hibernate_sequence, 500, 0);

INSERT INTO account_entity (id, user_id, status, balance_id, iban, currency) VALUES (NEXT VALUE FOR hibernate_sequence, 6, 'ACTIVE', 7, 'LT3212131544', 'EUR');