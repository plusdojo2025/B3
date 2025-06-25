
/*データベース作成*/
CREATE DATABASE b3;
use b3;

/*ユーザーテーブル作成*/
CREATE TABLE users (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name varchar(100) NOT NULL,
    password varchar(100),
    created_at timestamp,
    updated_at timestamp
);
INSERT INTO users (user_name, password, created_at, updated_at)
     VALUES ('id', 'password', NOW(), NOW());

/*perfumesテーブル作成*/
CREATE TABLE perfumes(
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    perfume_name varchar(100),
    brand_name varchar(100),
    price int,
    perfume_img varchar(255),
    day DATE,
    favourite BOOLEAN,
    color VARCHAR(7),
    strength INT,
    memo VARCHAR(100),
    created_at timestamp,
    updated_at timestamp
);
/* scrollballテーブル作成*/
CREATE TABLE scrollbar(
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    perfume_id INT,
    simple_complex INT,
    fresh_sweet INT,
    light_heavy INT,
    male_women INT,
    mild_spicy INT,
    FOREIGN KEY (perfume_id)
    REFERENCES perfumes(ID),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
    
);

    /*  perfume_logテーブル作成*/
CREATE TABLE perfume_log (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    perfume_id INT,
    user_id INT,
    applied_time TIME,
    temperature VARCHAR(4),
    weather VARCHAR(4),
    push_count VARCHAR(3),
    applied_area VARCHAR(30),
    usage_scene VARCHAR(3),
    top_note VARCHAR(100),
    middle_note VARCHAR(100),
    last_note VARCHAR(100),
    thoughts VARCHAR(100),
    created_at TIMESTAMP,
    updated_at TIMESTAMP ,
    FOREIGN KEY (perfume_id) REFERENCES perfumes(ID),
    FOREIGN KEY(user_id) REFERENCES users(ID)
);

 

/* big_categoryテーブル作成*/
CREATE TABLE big_category(
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    scent_type VARCHAR(20),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
/* small_categoryテーブル作成*/
CREATE TABLE small_category(
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    genre VARCHAR(10),
    detail VARCHAR(10),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

/* perfume_imagesテーブル作成*/
CREATE TABLE perfume_images (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    perfume_id INT,
    big_id INT,
    small_id INT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP ,
    FOREIGN KEY(perfume_id)
    REFERENCES perfumes(ID),
    FOREIGN KEY (big_id) 
    REFERENCES big_category(ID),
    FOREIGN KEY (small_id)
    REFERENCES small_category(ID)
);

Show tables;
