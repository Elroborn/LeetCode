"""
Created on 2019/6/5 19:44
@File:矩阵置零.py
@author: coderwangson
"""
"#codeing=utf-8"
# ref https://blog.csdn.net/smile_watermelon/article/details/45505709

class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        m,n = len(matrix),len(matrix[0])
        x,y = [0]*m,[0]*n # x[m]表示第m行为0 y[n]表示第n行为0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] ==0:
                    x[i] = 1
                    y[j]= 1
        for i,x_i in enumerate(x):
            if x_i==1: # 说明这一整行要置为0
                for j in range(n):
                    matrix[i][j] = 0

        for i,y_i in enumerate(y):
            if y_i==1: # 说明这一整列要置为0
                for j in range(m):
                    matrix[j][i] = 0
print(Solution().setZeroes([
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]))