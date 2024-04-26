# 一、说明

[about me](https://caoyang2002.top)



# 二、开始

## 1. install 

```bash
mvn install
```

## 2. create database

```sql
CREATE DATABASE qoobk CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE qoobk;

DROP TABLE IF EXISTS book;

CREATE TABLE book (
                      id MEDIUMINT NOT NULL AUTO_INCREMENT,
                      title CHAR(255) NOT NULL,
                      url VARCHAR(2048) CHARACTER SET utf8mb4,
                      PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```


## 3. update database

get book name

```bash
python3 main.py
```

update database

```bash
python3 insert_database_with_book_info.py
```


# 使用

## doc

http://localhost:8081/doc.html



