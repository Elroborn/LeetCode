"""
Created on 2019/4/17 21:42
@File:螺旋矩阵.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """

        res = []
        if len(matrix) == 0: return res
        x,y,dx,dy = 0,0,0,1
        for _ in range(len(matrix)*len(matrix[0])):
            res.append(matrix[x][y])
            # 走过的置一个特殊的
            matrix[x][y] = None
            # 在继续走下去之前，看看对应位置是否能走
            if matrix[(x+dx)%len(matrix)][(y+dy)%len(matrix[0])] ==None:
                # 走过了或者走到已经走过的，则换方向
                dx,dy = dy,-dx # 妙
            x+=dx
            y+=dy
        return res
print(Solution().spiralOrder([[]]))
