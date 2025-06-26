
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


/* ここから実際のデータ　*/
/* perfumes データ*/
INSERT INTO perfumes (perfume_name, brand_name, price, perfume_img, day, favourite, color, strength, memo, created_at, updated_at) VALUES
('English Pear & Sweet Pea ', 'Jo Malone London', 23650, '1.png', '2025-05-10', TRUE, '#FFFFE0', 4, '有名なやつ', NOW(), NOW()),
('maison Martin Margiela', 'Lazy Sunday Morning', 11510, '2.png', '2025-04-20', FALSE, '#f8f8ff', 3, 'マルジェラの1番人気', NOW(), NOW()),
('DIPTYQUE', 'DIPTYQUE', 29700, '3.png', '2025-03-20', TRUE, '#dcdcdc', 2, '店員さんのおすすめ', NOW(), NOW()),
('ANOTHER 13', 'LE LABO', 44000, '4.png', '2025-06-05', FALSE, '#008b8b', 2, 'さわやか系', NOW(), NOW()),
('BLANCHE', 'BYREDO', 18050, '5.png', '2025-06-22', TRUE, '#b0c4de', 2, '〇〇が使っている香水', NOW(), NOW());

SELECT * FROM perfumes;

/* users データ*/
INSERT INTO users (user_name, password, created_at, updated_at) VALUES
('dojouser1', '#SEplus2025SEplus', NOW(), NOW()),
('dojouser2', '#SEplus2025SEplus', NOW(), NOW());

/*big_categoryデータ*/
INSERT INTO big_category (scent_type, created_at, updated_at) VALUES
('甘さ', NOW(), NOW()),
('さわやかさ', NOW(), NOW()),
('スパイシー', NOW(), NOW()),
('リラックス', NOW(), NOW());

/*small_categoryデータ*/
INSERT INTO small_category (genre, detail, created_at, updated_at) VALUES
('スイーツ', '無し', NOW(), NOW()),
('スイーツ', 'あんこ', NOW(), NOW()),
('スイーツ', 'カスタード', NOW(), NOW()),
('スイーツ', 'カラメル', NOW(), NOW()),
('スイーツ', 'キャラメル', NOW(), NOW()),
('スイーツ', 'キャンディ', NOW(), NOW()),
('スイーツ', 'ケーキ', NOW(), NOW()),
('スイーツ', 'チョコレート', NOW(), NOW()),
('スイーツ', '生クリーム', NOW(), NOW()),
('スイーツ', 'はちみつ', NOW(), NOW()),
('スイーツ', 'バニラ', NOW(), NOW()),
('スイーツ', 'プリン', NOW(), NOW()),
('スイーツ', 'マシュマロ', NOW(), NOW()),
('スイーツ', 'メープルシロップ', NOW(), NOW()),
('スイーツ', 'モンブラン', NOW(), NOW()),
('スイーツ', 'わたあめ', NOW(), NOW()),
('果物', '無し', NOW(), NOW()),
('果物', 'あんず', NOW(), NOW()),
('果物', 'イチゴ', NOW(), NOW()),
('果物', 'イチジク', NOW(), NOW()),
('果物', 'オレンジ', NOW(), NOW()),
('果物', 'カシス', NOW(), NOW()),
('果物', 'グレープフルーツ', NOW(), NOW()),
('果物', 'ココナッツ', NOW(), NOW()),
('果物', 'サクランボ', NOW(), NOW()),
('果物', 'サツマイモ', NOW(), NOW()),
('果物', 'シトラス', NOW(), NOW()),
('果物', 'スイカ', NOW(), NOW()),
('果物', 'パイナップル', NOW(), NOW()),
('果物', 'ブドウ', NOW(), NOW()),
('果物', 'プラム', NOW(), NOW()),
('果物', 'ベルガモット', NOW(), NOW()),
('果物', 'マスカット', NOW(), NOW()),
('果物', 'マンゴー', NOW(), NOW()),
('果物', 'マンダリン', NOW(), NOW()),
('果物', 'メロン', NOW(), NOW()),
('果物', 'モモ', NOW(), NOW()),
('果物', '柚子', NOW(), NOW()),
('果物', 'ライム', NOW(), NOW()),
('果物', 'ラズベリー', NOW(), NOW()),
('果物', 'ラフランス', NOW(), NOW()),
('果物', 'リンゴ', NOW(), NOW()),
('果物', 'レモン', NOW(), NOW()),
('飲み物', '無し', NOW(), NOW()),
('飲み物', 'アールグレイ', NOW(), NOW()),
('飲み物', 'グリーンティー', NOW(), NOW()),
('飲み物', 'コーヒー', NOW(), NOW()),
('飲み物', 'ブラックティー', NOW(), NOW()),
('飲み物', 'ほうじ茶', NOW(), NOW()),
('飲み物', 'ミルク', NOW(), NOW()),
('飲み物', 'ミルクティー', NOW(), NOW()),
('スパイス', '無し', NOW(), NOW()),
('スパイス', 'クローブ', NOW(), NOW()),
('スパイス', 'シナモン', NOW(), NOW()),
('スパイス', 'ショウガ', NOW(), NOW()),
('スパイス', '唐辛子', NOW(), NOW()),
('スパイス', 'ペッパー', NOW(), NOW()),
('スパイス', 'ワサビ', NOW(), NOW()),
('シーン', '無し', NOW(), NOW()),
('シーン', 'オゾンノート', NOW(), NOW()),
('シーン', 'シーソルト', NOW(), NOW()),
('シーン', '石鹸', NOW(), NOW()),
('シーン', 'ソファ', NOW(), NOW()),
('シーン', '太陽', NOW(), NOW()),
('シーン', '畳', NOW(), NOW()),
('シーン', 'ムスク', NOW(), NOW()),
('シーン', '海', NOW(), NOW()),
('シーン', '映画館', NOW(), NOW()),
('シーン', 'カフェ', NOW(), NOW()),
('シーン', 'サウナ', NOW(), NOW()),
('シーン', '森林', NOW(), NOW()),
('シーン', '茶室', NOW(), NOW()),
('シーン', 'ディズニー', NOW(), NOW()),
('シーン', '寺', NOW(), NOW()),
('シーン', '庭', NOW(), NOW()),
('シーン', 'ビーチ', NOW(), NOW()),
('シーン', '美容室', NOW(), NOW()),
('シーン', 'プール', NOW(), NOW()),
('シーン', '風呂', NOW(), NOW()),
('シーン', 'ベッドルーム', NOW(), NOW()),
('シーン', 'ホテル', NOW(), NOW()),
('シーン', '山', NOW(), NOW()),
('シーン', '旅館', NOW(), NOW()),
('シーン', '春', NOW(), NOW()),
('シーン', '夏', NOW(), NOW()),
('シーン', '秋', NOW(), NOW()),
('シーン', '冬', NOW(), NOW()),
('植物', '無し', NOW(), NOW()),
('植物', 'アーモンド', NOW(), NOW()),
('植物', 'イランイラン', NOW(), NOW()),
('植物', 'ウッド', NOW(), NOW()),
('植物', 'カモミール', NOW(), NOW()),
('植物', 'キンモクセイ', NOW(), NOW()),
('植物', 'ジャスミン', NOW(), NOW()),
('植物', 'スズラン', NOW(), NOW()),
('植物', 'ネロリ', NOW(), NOW()),
('植物', 'バジル', NOW(), NOW()),
('植物', 'ヒノキ', NOW(), NOW()),
('植物', '白檀', NOW(), NOW()),
('植物', 'マリーゴールド', NOW(), NOW()),
('植物', 'ミモザ', NOW(), NOW()),
('植物', 'ミント', NOW(), NOW()),
('植物', 'ユーカリ', NOW(), NOW()),
('植物', 'ラベンダー', NOW(), NOW()),
('植物', 'ローズ', NOW(), NOW()),
('植物', 'ローズマリー', NOW(), NOW());

/*scrollbarデータ*/
INSERT INTO scrollbar (perfume_id, simple_complex, fresh_sweet, light_heavy, male_women, mild_spicy, created_at, updated_at) VALUES
(1, 24, 44, 84, 62, 21, NOW(), NOW()),
(2, 40, 30, 100, 66, 21, NOW(), NOW()),
(3, 34, 42, 95, 60, 4, NOW(), NOW()),
(4, 10, 36, 61, 72, 11, NOW(), NOW()),
(5, 27, 50, 90, 88, 10, NOW(), NOW());

/* perfume images データ*/
INSERT INTO perfume_images (perfume_id, big_id, small_id,created_at, updated_at) VALUES
(1, 1, 10, NOW(), NOW()),
(1, 2, 33, NOW(), NOW()),
(1, 2, 45, NOW(), NOW()),
(1, 3, 52, NOW(), NOW()),
(1, 4, 85, NOW(), NOW()),
(2, 1, 41, NOW(), NOW()),
(2, 2, 41, NOW(), NOW()),
(2, 3, 52, NOW(), NOW()),
(2, 4, 62, NOW(), NOW()),
(3, 1, 21, NOW(), NOW()),
(3, 2, 21, NOW(), NOW()),
(3, 3, 52, NOW(), NOW()),
(3, 4, 45, NOW(), NOW()),
(4, 1, 41, NOW(), NOW()),
(4, 2, 38, NOW(), NOW()),
(4, 3, 52, NOW(), NOW()),
(4, 4, 62, NOW(), NOW()),
(5, 1, 41, NOW(), NOW()),
(5, 2, 38, NOW(), NOW()),
(5, 3, 55, NOW(), NOW()),
(5, 4, 85, NOW(), NOW()),
(5, 4, 62, NOW(), NOW());

/* perfume_log データ*/
INSERT INTO perfume_log (user_id, perfume_id, applied_time,temperature, weather, push_count, applied_area, usage_scene, top_note, middle_note, last_note, thoughts, created_at, updated_at) VALUES

(1, 2, '2025-05-10 10:25:00', 25.4, 1, 2, 3, 1, 'さわやかで目が覚めるような柑橘の香り', 'ちょっと甘酸っぱくてジューシーな果実感', 'レモンの香り', '夏にちょうどいい', NOW(), NOW()),
(1, 2, '2025-05-25 14:00:00', 26.4, 3, 1, 2, 2, '柑橘', 'レモン・シトラス', 'レモン', 'いつもと変わらない', NOW(), NOW()),
(1, 1, '2025-06-01 09:45:00', 27.2, 1, 1, 4, 1, '甘めのバニラ', 'バニラ感はあまりなくなる', 'すっきりした香り', 'なし', NOW(), NOW()),
(1, 3, '2025-06-10 07:25:00', 28.5, 3, 2, 1, 2, 'ウッディ系', 'ウッディ系', 'トップノートとあまり変わらない', '初めて使ったけど良かった', NOW(), NOW()),
(1, 2, '2025-06-14 9:02:00', 26.6, 2, 3, 3, 3, 'さわやかで目が覚めるような柑橘の香り', 'ちょっと甘酸っぱくてジューシーな果実感', 'レモンの香り', '今の時期にいい', NOW(), NOW());
(1, 1, '2025-06-22 18:25:00', 25.4, 1, 1, 3, 3, 'さわやかで目が覚めるような柑橘の香り', 'ちょっと甘酸っぱくてジューシーな果実感', 'レモンの香り', '夏にちょうどいい', NOW(), NOW());
(1, 2, '2025-06-26 10:25:00', 30.4, 1, 2, 3, 2, '柑橘の香り', 'フルーティー', 'レモンの香り', '暑いと香りが継続しにくいかも', NOW(), NOW());

SELECT * FROM perfume_log;