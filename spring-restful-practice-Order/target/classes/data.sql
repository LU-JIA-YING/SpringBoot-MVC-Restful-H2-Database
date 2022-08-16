--http://localhost:8080/h2-console

INSERT INTO orders (TOTAL_PRICE, waiter) VALUES (170,'Joey');
INSERT INTO orders (TOTAL_PRICE, waiter) VALUES (320,'Maggie');


INSERT INTO meal (name, price, description) VALUES ('hamburger', 120, 'This is delicious');
INSERT INTO meal (name, price, description) VALUES ('ice cream', 50, 'YM~YM~');

INSERT INTO meal (name, price, description) VALUES ('salads', 100, 'QQ');
INSERT INTO meal (name, price, description) VALUES ('ice cream', 50, 'YM~YM~');
INSERT INTO meal (name, price, description) VALUES ('rice', 50, 'Really good!');
INSERT INTO meal (name, price, description) VALUES ('sandwiches', 120, 'Tastes great!');


INSERT INTO ORDERS_MEAL_LIST(order_seq, MEAL_LIST_ID) VALUES(1, 1);
INSERT INTO ORDERS_MEAL_LIST(order_seq, MEAL_LIST_ID) VALUES(1, 2);
INSERT INTO ORDERS_MEAL_LIST(order_seq, MEAL_LIST_ID) VALUES(2, 3);
INSERT INTO ORDERS_MEAL_LIST(order_seq, MEAL_LIST_ID) VALUES(2, 4);
INSERT INTO ORDERS_MEAL_LIST(order_seq, MEAL_LIST_ID) VALUES(2, 5);
INSERT INTO ORDERS_MEAL_LIST(order_seq, MEAL_LIST_ID) VALUES(2, 6);