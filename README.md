# 一、说明

[about me](https://caoyang2002.top)



# 二、开始

## 1. install 

```bash
mvn install
```

## 2. create database

```sql
CREATE DATABASE qoobk; -- 创建数据库
USE qoobk;
CREATE TABLE book
(
    id   MEDIUMINT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id),
    title CHAR(32)  NOT NULL,
    url  varchar(256) char set utf8
);
SHOW TABLES;
DESCRIBE book;
-- 这是测试数据
-- 插入第一本书的数据
INSERT INTO book (title, url) VALUES ('1984', 'http://example.com/1984');

-- 插入第二本书的数据
INSERT INTO book (title, url) VALUES ('To Kill a Mockingbird', 'http://example.com/to-kill-a-mockingbird');

-- 插入第三本书的数据
INSERT INTO book (title, url) VALUES ('The Great Gatsby', 'http://example.com/the-great-gatsby');

SELECT * FROM book WHERE id=1;

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



