-- Create database
-- CREATE DATABASE bookstore;

-- Create users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    address VARCHAR(255),
    role VARCHAR(20) NOT NULL CHECK (role IN ('ADMIN', 'USER'))
);

-- Create books table
CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE,
    price NUMERIC NOT NULL,
    quantity INT NOT NULL
);

-- Create orders table
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    total_price NUMERIC NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Create order_items table
CREATE TABLE order_items (
    id SERIAL PRIMARY KEY,
    order_id INT NOT NULL,
    book_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);

-- Insert sample users
INSERT INTO users (username, password, email, address, role) VALUES
('admin1', 'password1', 'admin1@example.com', '123 Admin St', 'ADMIN'),
('admin2', 'password2', 'admin2@example.com', '456 Admin St', 'ADMIN'),
('user1', 'password1', 'user1@example.com', '789 User St', 'USER'),
('user2', 'password2', 'user2@example.com', '101 User St', 'USER'),
('user3', 'password3', 'user3@example.com', '202 User St', 'USER'),
('user4', 'password4', 'user4@example.com', '303 User St', 'USER'),
('user5', 'password5', 'user5@example.com', '404 User St', 'USER'),
('user6', 'password6', 'user6@example.com', '505 User St', 'USER'),
('user7', 'password7', 'user7@example.com', '606 User St', 'USER'),
('user8', 'password8', 'user8@example.com', '707 User St', 'USER');

-- Insert sample books
INSERT INTO books (title, author, isbn, price, quantity) VALUES
('Book Title 1', 'Author 1', 'ISBN0001', 19.99, 10),
('Book Title 2', 'Author 2', 'ISBN0002', 29.99, 5),
('Book Title 3', 'Author 3', 'ISBN0003', 39.99, 7),
('Book Title 4', 'Author 4', 'ISBN0004', 49.99, 12),
('Book Title 5', 'Author 5', 'ISBN0005', 59.99, 8),
('Book Title 6', 'Author 6', 'ISBN0006', 69.99, 3),
('Book Title 7', 'Author 7', 'ISBN0007', 79.99, 4),
('Book Title 8', 'Author 8', 'ISBN0008', 89.99, 6),
('Book Title 9', 'Author 9', 'ISBN0009', 99.99, 9),
('Book Title 10', 'Author 10', 'ISBN0010', 109.99, 11),
('Book Title 11', 'Author 11', 'ISBN0011', 119.99, 2),
('Book Title 12', 'Author 12', 'ISBN0012', 129.99, 1),
('Book Title 13', 'Author 13', 'ISBN0013', 139.99, 13),
('Book Title 14', 'Author 14', 'ISBN0014', 149.99, 14),
('Book Title 15', 'Author 15', 'ISBN0015', 159.99, 15),
('Book Title 16', 'Author 16', 'ISBN0016', 169.99, 16),
('Book Title 17', 'Author 17', 'ISBN0017', 179.99, 17),
('Book Title 18', 'Author 18', 'ISBN0018', 189.99, 18),
('Book Title 19', 'Author 19', 'ISBN0019', 199.99, 19),
('Book Title 20', 'Author 20', 'ISBN0020', 209.99, 20);

-- Insert sample orders
INSERT INTO orders (user_id, total_price) VALUES
(3, 39.98),
(4, 59.97),
(5, 29.98);

-- Insert sample order_items
INSERT INTO order_items (order_id, book_id, quantity) VALUES
(1, 1, 2),
(2, 2, 1),
(2, 3, 1),
(3, 4, 1);
