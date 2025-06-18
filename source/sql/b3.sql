
/*データベース作成*/
CREATE DATABASE b3;
use b3;

/*ユーザーテーブル作成*/
CREATE TABLE users (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_name varchar(100) NOT NULL,
    password varchar(100),
    mail_address varchar(100),
    created_at timestamp,
    updated_at timestamp
);

/*perfumesテーブル作成*/
CREATE TABLE perfumes(
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    perfume_name varchar(100),
    brand_name varchar(100),
    price int,
    perfume_img varchar(200),
    day DATE,
    favourite BOOLEAN,
    color VARCHAR(7),
    strength INT,
    memo VARCHAR(100),
    created_at timestamp,
    updated_at timestamp
);


/* perfume_imagesテーブル作成*/
CREATE TABLE perfume_images (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    perfume_id INT,
    item VARCHAR(10),
    small_category VARCHAR(10),
     created_at TIMESTAMP,
    updated_at TIMESTAMP ,
    FOREIGN KEY (perfume_id) REFERENCES perfumes(ID),
    
);


    /*  perfume_logテーブル作成*/
CREATE TABLE perfume_log (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    perfume_id INT,
    applied_time TIME,
    temperature FLOAT(4),
    weather INT,
    push_count INT,
    applied_area VARCHAR(30),
    usage_scene INT,
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
    sweet VARCHAR(100),
    fresh VARCHAR(100),
    spicy VARCHAR(100),
    relax VARCHAR(100),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
/* details_categoryテーブル作成*/
CREATE TABLE detail_category(
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    genre VARCHAR(10),
    big_id INT,
    FOREIGN KEY (big_id) 
    REFERENCES big_categpry(ID),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
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
    FOREIGN KEY (perfume_id) REFERENCES perfumes(ID),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
    
);

Show tables;