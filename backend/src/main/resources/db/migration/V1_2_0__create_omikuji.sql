CREATE TABLE omikuji (
    id INT AUTO_INCREMENT PRIMARY KEY,
    owner INT,
    shrine_id INT,
    fortune VARCHAR(32),
    FOREIGN KEY (owner) REFERENCES user(id),
    FOREIGN KEY (shrine_id) REFERENCES shrine(id)
);
