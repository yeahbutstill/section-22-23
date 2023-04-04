# section-22-23
## Run docker mysql
```shell
docker run --rm \ 
--name=multi-bahasa-db \
-e MYSQL_DATABASE=multibahasadb \
-e MYSQL_USER=dani \
-e MYSQL_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e MYSQL_ROOT_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e TZ=Asia/Jakarta \
-p 6603:3306 \
-v "$PWD/docker/multi-bahasa-db/conf.d":/etc/mysql/conf.d \
-v "$PWiD/storage/docker/multi-bahasa-data":/var/lib/mysql \
mysql:8
```
```shell
mysql -uroot -p -h127.0.0.1 -P6603 
```
```sql
SHOW DATABASES;
```
```sql
CREATE TABLE categories(
    id VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY(id)
)ENGINE InnoDB;

INSERT INTO categories(id, position) VALUES('FOOD', 1);
INSERT INTO categories(id, position) VALUES('GADGET', 2);
INSERT INTO categories(id, position) VALUES('FASHION', 3);


SELECT * from categories ORDER BY position;
    
CREATE TABLE categories_translations(
    category_id VARCHAR(100) NOT NULL,
    language VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    PRIMARY KEY (category_id, language)
)ENGINE InnoDB;

ALTER TABLE categories_translations 
    ADD CONSTRAINT fk_categories_translation 
        FOREIGN KEY (category_id) REFERENCES categories (id);

SELECT * FROM categories 
    JOIN categories_translations ct 
        ON categories.id = ct.category_id;

INSERT INTO categories_translations(category_id, language, name, description) 
VALUES ('FOOD', 'in_ID', 'Makanan', 'Deskripsi Makanan');
INSERT INTO categories_translations(category_id, language, name, description) 
VALUES ('FOOD', 'en_US', 'Food', 'Food Description');
INSERT INTO categories_translations(category_id, language, name, description) 
VALUES ('GADGET', 'in_ID', 'Gawai', 'Deskripsi Gawai');
INSERT INTO categories_translations(category_id, language, name, description) 
VALUES ('GADGET', 'en_US', 'Gadget', 'Gadget Description');

--- QUERY usernya login di Indonesia ---
SELECT * FROM categories 
    JOIN categories_translations ct 
        ON categories.id = ct.category_id 
            WHERE ct.language = 'in_ID' ORDER BY position;

--- QUERY usernya login di Amerika ---
SELECT * FROM categories
    JOIN categories_translations ct
        ON categories.id = ct.category_id
         WHERE ct.language = 'en_US' ORDER BY position;
```