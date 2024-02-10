CREATE TABLE category_fortune (
    omikuji_id INT,
    category INT,
    content TEXT,
    score INT,
    opinion TEXT,
    PRIMARY KEY (omikuji_id, category),
    FOREIGN KEY (omikuji_id) REFERENCES omikuji(id)
);
