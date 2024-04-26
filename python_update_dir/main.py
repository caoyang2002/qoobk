import os
import json



def get_files_in_directory(directory):
    file_list = []
    for root, dirs, files in os.walk(directory):
        for file in files:
            # 获取相对于指定目录的绝对路径
            relative_root = os.path.relpath(root, directory)
            file_path = os.path.join(os.path.abspath(relative_root), file)
            file_list.append({"title": file, "url": file_path})
    return file_list

def main():
    # 获取当前目录的路径
    # directory_path = os.getcwd()

    # 指定您想要搜索的目录路径
    directory_path = "E:\BOOK"

    # 获取指定目录下的所有文件及其路径
    files_json = get_files_in_directory(directory_path)

    # 打开文件并写入JSON数据
    with open("files.json", "w", encoding="utf-8") as json_file:
        json.dump(files_json, json_file, indent=4, ensure_ascii=False)

if __name__ == "__main__":
    main()
