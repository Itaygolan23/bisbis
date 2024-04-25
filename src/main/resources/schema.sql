CREATE TABLE IF NOT EXISTS task (
  description VARCHAR(64) NOT NULL,
  completed   VARCHAR(30) NOT NULL);


-- An example of creating table to every API for testing
CREATE TABLE IF NOT EXISTS RESTAURANT (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  average_rating DECIMAL(4, 2),
  is_kosher BOOLEAN,
  cuisines VARCHAR(255)
  );

CREATE TABLE IF NOT EXISTS Dish (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  description VARCHAR(255),
  price DECIMAL(10, 2),
  restaurant_id INT,
  FOREIGN KEY (restaurant_id) REFERENCES Restaurant(id)
  );


CREATE TABLE IF NOT EXISTS rating (
  id INT AUTO_INCREMENT PRIMARY KEY,
  rating DECIMAL(4, 2),
  restaurant_id INT,
  FOREIGN KEY (restaurant_id) REFERENCES restaurant(id)
  );
