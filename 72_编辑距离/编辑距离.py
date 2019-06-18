"""
Created on 2019/6/3 14:15
@File:编辑距离.py
@author: coderwangson
"""
"#codeing=utf-8"

# ref https://blog.csdn.net/Koala_Tree/article/details/80074722
class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        rows,cols = len(word1),len(word2)
        # dp[i][j]代表第一个串的[0:i]到第二个串的[0:j]的距离（不包括i和j）
        dp = [[0]* (cols+1) for _ in range((rows+1))] # 避免两个空串
        # dp[0][j] = j以及dp[i][0] = i因为有个串是空串另个串需要对应长度的删除变化才能变为空串
        i,j = 0,0
        for i in range(1,rows+1):
            dp[i][0] = i
        for j in range(1,cols+1):
            dp[0][j] = j
        for i in range(1,rows+1):
            for j in range(1,cols+1):
                if word1[i-1] == word2[j-1]:dp[i][j] = dp[i-1][j-1]
                # 分三种情况取最小的  插入 dp[i][j-1] + 1  删除dp[i-1][j] +1 替换 dp[i-1][j-1] + 1
                else:dp[i][j] = min(dp[i][j-1] + 1,dp[i-1][j] +1,dp[i-1][j-1] + 1)
        return dp[i][j]

print(Solution().minDistance("orse","horse"))