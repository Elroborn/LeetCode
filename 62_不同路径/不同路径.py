"""
Created on 2019/5/8 17:11
@File:不同路径.py
@author: coderwangson
"""
"#codeing=utf-8"
# https://juejin.im/post/5b927e795188255c6c621e11

class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        dp = [[1]*m for i in range(n)]
        for i in range(1,n):
            for j in range(1,m):
                print(i,j)
                dp[i][j] = dp[i-1][j] + dp[i][j-1]

        return dp[n-1][m-1]

print(Solution().uniquePaths(7,3))
