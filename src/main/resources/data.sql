INSERT INTO task ( description, completed) VALUES
  ( 'description1', 'completed'),
  ('description2', 'completed');

INSERT INTO RESTAURANT (average_rating, is_kosher, name, cuisines)
VALUES (4.8, FALSE, 'ITAY', 'Mexican, Indian');

INSERT INTO RESTAURANT (average_rating, is_kosher, name, cuisines)
VALUES (4.8, FALSE, 'TG', 'Asian, Mexican, Indian');

INSERT INTO Dish (name, description, price, restaurant_id)
VALUES ('Shakshuka', 'Great one', 34.00, 1);

INSERT INTO rating (restaurant_id, rating)
VALUES (1, 3.3);


