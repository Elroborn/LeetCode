"""
Created on 2019/6/11 19:19
@File:搜索二维矩阵.py
@author: coderwangson
"""
"#codeing=utf-8"
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix)==0:return False
        m = len(matrix)
        n = len(matrix[0])
        l = m*n
        left = 0
        right = l-1
        while left<=right:
            mid = (left + right) //2
            i,j = mid//n,mid%n
            if matrix[i][j] == target:return True
            elif matrix[i][j]>target:right = mid -1
            else:left = mid+1
        return False
print(Solution().searchMatrix([[1,1]],2))
