# import json
# import pymysql
#
# # 连接到MySQL数据库
# connection = pymysql.connect(host='localhost',
#                              user='root',
#                              password='root',
#                              database='qoobk',
#                              charset='utf8mb4',
#                              cursorclass=pymysql.cursors.DictCursor)
# # 检查连接是否成功
# if connection is not None:
#     print("连接成功")
# else:
#     print("连接失败")
#
#
# # JSON文件路径
# json_file_path = 'files.json'
#
# # 读取JSON文件
# with open(json_file_path, 'r', encoding='utf-8') as file:
#     json_data = json.load(file)
#     print(json_data)
#
#
# try:
#     # 插入数据
#     for item in json_data:
#         title = item["title"]
#         url = item["url"]
#         print(title+" ===== " +url + "\n")
#         # SQL 插入语句
#         sql_query = "INSERT INTO files (title, url) VALUES (%s, %s)"
#         print(sql_query)
#
#         params = [(item['title'], item['url']) for item in json_data]
#
#         # 执行SQL查询
#         pymysql
#         cursor.executemany(sql_query, params)
#         connection.commit()
#
#
#     # 提交更改
#     print("数据插入成功！")
#
# except Exception as e:
#     print(f"发生异常：{e}")
#     connection.rollback()
#
#
# finally:
#     # 关闭数据库连接
#     connection.close()






from sqlalchemy.exc import SQLAlchemyError

import json

from sqlalchemy import create_engine, Column, Integer, String
from sqlalchemy.orm import sessionmaker
#
# # 创建数据库引擎
# engine = create_engine('mysql+pymysql://root:root@localhost/qoobk', echo=True)
#
# # 创建会话类
# Session = sessionmaker(bind=engine)
#
# # 创建表结构
# from sqlalchemy.orm import declarative_base
# import logging
#
# # 使用 SQLAlchemy 2.0 推荐的 declarative_base
# Base = declarative_base()
#
#
# class Book(Base):
#     __tablename__ = 'book'
#     id = Column(Integer, primary_key=True, autoincrement=True)
#     title = Column(String(225))
#     url = Column(String(2048))
#
#
# # 读取JSON文件
# with open('files.json', 'r', encoding='utf-8') as file:
#     json_data = json.load(file)
#
# # 创建会话
# session = Session()
#
# try:
#     # 批量插入数据
#     session.bulk_insert_mappings(Book, json_data)
#
#     # 在提交之前显式地flush
#
#     session.flush()
#     logging.info("Flushed the session. Checking for new objects...")
#
#     # 检查是否有错误
#     if session.new:
#         logging.info("All records were successfully added to the database.")
#     else:
#         print("There were errors during the flush operation.")
#         for state in session.new:
#             logging.error(f"Object with primary key {state.identity_key} failed to insert.")
#         # 如果需要，可以在这里中断程序或进行其他错误处理
#
#     session.commit()
#
#     # 提交更改
#     print("数据插入成功！")
#
# except SQLAlchemyError as e:
#     # 打印异常信息，包括 traceback
#     logging.error(f"发生数据库异常：{e}")
#     logging.error(e.__traceback__.tb_lineno)  # 获取错误发生的行号
#     session.rollback()  # 回滚事务
#     raise e  # 重新抛出异常，以便进一步处理
#
#
# except Exception as e:
#     print(f"发生异常：{e}")
#     session.rollback()
#
# finally:
#     # 关闭会话
#     session.close()















from sqlalchemy.exc import SQLAlchemyError
import json
import logging

# 创建数据库引擎
engine = create_engine('mysql+pymysql://root:root@localhost/qoobk', echo=True)

# 创建会话类
Session = sessionmaker(bind=engine)

# 创建表结构
from sqlalchemy.orm import declarative_base
import logging

# 使用 SQLAlchemy 2.0 推荐的 declarative_base
Base = declarative_base()


class Book(Base):
    __tablename__ = 'book'
    id = Column(Integer, primary_key=True, autoincrement=True)
    title = Column(String(225))
    url = Column(String(2048))


# 读取JSON文件
with open('files.json', 'r', encoding='utf-8') as file:
    json_data = json.load(file)



# 配置日志
logging.basicConfig(level=logging.INFO)

# 假设每批处理1000条数据
BATCH_SIZE = 1000

# 创建会话
session = Session()

try:
    # 分批插入数据
    for i in range(0, len(json_data), BATCH_SIZE):
        batch = json_data[i:i + BATCH_SIZE]
        session.bulk_insert_mappings(Book, batch)
        session.flush()  # 显式地flush每个批次
        logging.info(f"Flushed batch {i // BATCH_SIZE + 1} of {len(json_data) // BATCH_SIZE}")

    session.commit()
    logging.info("All data has been successfully inserted.")

except SQLAlchemyError as e:
    logging.error(f"Database error occurred: {e}")
    session.rollback()  # 回滚事务

    raise e  # 重新抛出异常

except Exception as e:
    logging.error(f"An unexpected error occurred: {e}")
    session.rollback()

finally:
    session.close()
    logging.info("Session closed.")
