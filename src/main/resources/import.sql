INSERT INTO "customer_info" ("id", "email", "first_name", "last_name") VALUES
  (1, E'email1', E'ivan', E'ivanov'),
  (2, E'email2', E'petr', E'sidorov'),
  (3, E'email3', E'nikolai', E'romanov'),
  (4, E'email4', E'mikl', E'petrov'),
  (5, E'email5', E'petr', E'kolins');

INSERT INTO "customer" ("id", "customer_info_id") VALUES
  (1, 1),
  (2, 2),
  (3, 5),
  (4, 4),
  (5, 3);

INSERT INTO "item" ("id", "name", "price") VALUES
  (1, E'milk', 5),
  (2, E'juice', 6),
  (3, E'bread', 20),
  (4, E'book', 150),
  (5, E'table', 1700),
  (6, E'pen', 4),
  (7, E'apple', 15),
  (8, E'pc', 2875),
  (9, E'laptop', 3000),
  (10, E'mobile', 750);

INSERT INTO "ordering" ("id", "customer_id") VALUES
  (1, 1),
  (2, 1),
  (3, 1),
  (4, 2),
  (5, 3),
  (6, 3),
  (7, 4),
  (8, 4),
  (9, 2),
  (10, 5),
  (11, 5),
  (12, 5),
  (13, 5);

INSERT INTO "order_item" ("ordering_id", "item_id") VALUES
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 1),
  (5, 5),
  (6, 7),
  (7, 5),
  (8, 1),
  (9, 9),
  (9, 8),
  (11, 7),
  (12, 8),
  (13, 9),
  (1, 4),
  (1, 5),
  (1, 6),
  (2, 9),
  (7, 8);

INSERT INTO "storage" ("id") VALUES
  (1),
  (2);

INSERT INTO "item_balance" ("id", "quantity", "item_id", "storage_id") VALUES
  (1, 15, 1, 1),
  (2, 5, 2, 1),
  (3, 65, 3, 1),
  (4, 5, 4, 1),
  (5, 7, 5, 1),
  (6, 5, 6, 1),
  (7, 35, 7, 1),
  (8, 9, 8, 1),
  (9, 8, 9, 1),
  (10, 2, 10, 1),
  (11, 90, 1, 2),
  (12, 80, 6, 2);

INSERT INTO "storage_item_count" ("storage_id", "balance_id") VALUES
  (1, 3),
  (1, 2),
  (1, 5),
  (1, 4),
  (1, 8),
  (1, 7),
  (1, 6),
  (1, 9),
  (1, 1),
  (1, 10),
  (2, 11),
  (2, 12);

