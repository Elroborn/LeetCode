"""
Created on 2019/4/26 21:53
@File:螺旋矩阵 II.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        res = [[None]*n for _ in range(n)]

        x,y,nx,ny = 0,0,0,1
        for i in range(n*n):
            res[x][y] = i+1
            if not res[(x+nx)%n][(y+ny)%n] is None:# 说明来过了，换方向
                nx, ny = ny, -nx
            x+=nx
            y+=ny
        return res

print(Solution().generateMatrix(3))