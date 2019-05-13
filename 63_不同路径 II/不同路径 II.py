"""
Created on 2019/5/13 17:19
@File:不同路径 II.py
@author: coderwangson
"""
"#codeing=utf-8"
# https://blog.csdn.net/guoziqing506/article/details/51671722

class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        dp = [[1]*n for i in range(m)] # TODO 缺少一个判断这个不一定刚开始就都初始化1 比如[[1]]第一个就堵了，则为0 
        for i in range(1,m):
            for j in range(1,n):
                if obstacleGrid[i][j] == 1: dp[i][j] =0 # 如果障碍，则不能通过，所以置为0
                else: dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[m-1][n-1]

print(Solution().uniquePathsWithObstacles(

    [[0, 0], [1, 1], [0, 0]]))
