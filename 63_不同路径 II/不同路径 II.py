"""
Created on 2019/5/13 17:19
@File:不同路径 II.py
@author: coderwangson
"""
"#codeing=utf-8"
class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        dp = [[1]*m for i in range(n)]
        for i in range(1,m):
            for j in range(1,n):
                if obstacleGrid[i][j] == 1: dp[i][j] =0 # 如果障碍，则不能通过，所以置为0
                else: dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[n-1][m-1]

print(Solution().uniquePathsWithObstacles(
    [[0, 0]]))
