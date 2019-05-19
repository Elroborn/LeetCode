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
        if m==0 or obstacleGrid[0][0]==1: # 没有路，或者出门就堵了
            return 0
        dp = [[1 for j in range(n)] for i in range(m)] #
        # 从0,0开始发散
        for i in range(m):
            for j in range(n):
                if obstacleGrid[i][j] == 1: dp[i][j] =0 # 如果障碍，则不能通过，所以置为0
                elif j==0: dp[i][j] = dp[i-1][j] # j==0即为最左边的一列，所以和上面相关
                elif i==0: dp[i][j] = dp[i][j-1]
                else: dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[m-1][n-1]

print(Solution().uniquePathsWithObstacles([[1, 0]]))
