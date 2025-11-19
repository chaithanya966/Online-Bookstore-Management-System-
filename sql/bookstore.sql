-- Minimal schema for OnlineBookstore
CREATE DATABASE IF NOT EXISTS online_bookstore;
USE online_bookstore;

CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  fullname VARCHAR(200),
  role ENUM('USER','ADMIN') DEFAULT 'USER'
);

CREATE TABLE IF NOT EXISTS books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255),
  price DECIMAL(10,2) NOT NULL,
  stock INT DEFAULT 0,
  description TEXT
);

CREATE TABLE IF NOT EXISTS orders (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  total DECIMAL(10,2) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS order_items (
  id INT AUTO_INCREMENT PRIMARY KEY,
  order_id INT NOT NULL,
  book_id INT NOT NULL,
  qty INT NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
  FOREIGN KEY (book_id) REFERENCES books(id)
);

-- Insert a default admin (password: admin123) - hash not implemented in this scaffold
INSERT INTO users (username, password, fullname, role) VALUES ('admin','admin123','Administrator','ADMIN');
INSERT INTO books (title, author, price, stock, description) VALUES
('Effective Java','Joshua Bloch',450.00,10,'Best practices for Java'),
('Clean Code','Robert C. Martin',399.00,8,'A handbook of agile software craftsmanship');
