"""
Created on 2019/3/2 20:26
@File:全排列dfs.py
@author: coderwangson
"""
# 啊哈c https://blog.csdn.net/ccDLlyy/article/details/52728278
"#codeing=utf-8"
data =['A','B','C']
book =[0 for i in range(len(data))]
res = [0 for i in range(len(data))]
def dfs(i):
    if i ==len(data):
        print(res)
    else:
        for i in range(0,len(data)):
            if book[i]==0:
                res[i] = data[i]
                book[i] = 1
                dfs(i+1)
                book[i] =0

dfs(0)
