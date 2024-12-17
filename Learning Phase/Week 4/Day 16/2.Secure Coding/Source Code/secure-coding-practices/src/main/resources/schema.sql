DROP table IF EXISTS users;

-- Create a table named "users" for storing user data
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    encrypted_password BYTEA NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(15),
    role VARCHAR(50) NOT NULL -- New column to store roles like 'USER' or 'ADMIN'
);

-- Inserting sample users into the 'users' table with encrypted_password column
-- Correct way to insert plain text as a BYTEA (using convert_to for encryption example purposes)
INSERT INTO users (name, email, encrypted_password, role) VALUES
('John Doe', 'john.doe@example.com', convert_to('ENCRYPTED_PASSWORD_123', 'UTF8'), 'USER'),
('Jane Smith', 'jane.smith@example.com', convert_to('ENCRYPTED_PASSWORD_456', 'UTF8'), 'USER'),
('Alice Johnson', 'alice.johnson@example.com', convert_to('ENCRYPTED_PASSWORD_789', 'UTF8'), 'USER'),
('Bob Brown', 'bob.brown@example.com', convert_to('ENCRYPTED_PASSWORD_321', 'UTF8'), 'ADMIN');

-- Query to check if the data is inserted
SELECT * FROM users;
