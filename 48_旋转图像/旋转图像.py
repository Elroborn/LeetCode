"""
Created on 2019/4/12 22:00
@File:旋转图像.py
@author: coderwangson
"""
"#codeing=utf-8"
# ref https://leetcode-cn.com/problems/rotate-image/comments/

class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        # 先转置，再镜像
        # 转置 遍历下三角，转置到上三角
        for i in range(len(matrix)):
            for j in range(0,i):
                matrix[i][j],matrix[j][i] =(matrix[j][i],matrix[i][j])
        # 镜像
        for i in range(len(matrix)):
            for j in range(0,len(matrix[i])//2):
                t = len(matrix)-1-j
                matrix[i][j],matrix[i][t] = (matrix[i][t],matrix[i][j])


print(Solution().rotate([[1,2,3],[4,5,6],[7,8,9]]))