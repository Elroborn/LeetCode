"""
Created on 2019/4/3 21:17
@File:通配符匹配.py
@author: coderwangson
"""
"#codeing=utf-8"
# ref https://blog.csdn.net/qq_17550379/article/details/84191382
class Solution:
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        n = len(s)
        m = len(p)
        dp = [[False for j in range(len(p) + 1)] for i in range(len(s) + 1)]
        dp[0][0] = True
        for i in range(n+1):
            #若p为空，则只有dp[0,0] =True
            for j in range(1,m+1):
                if p[j-1] =="*":
                    # dp[i][j - 1]代表* 代表什么都不匹配
                    # dp[i-1][j]代表* 匹配一个或多个，因为反复调用所以有多个的效果
                    # 一个为True则dp[i][j]为True
                    dp[i][j] = dp[i][j-1] or dp[i-1][j]
                else:
                    if i>0:
                        dp[i][j] = dp[i-1][j-1] and (s[i-1]==p[j-1] or p[j-1] =="?")

        return dp[n][m]
print(Solution().isMatch("adceb","*a*b"))

