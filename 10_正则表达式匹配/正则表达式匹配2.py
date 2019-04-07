'''
Created on 2018年12月21日

@author: coderwangson
'''
"#codeing=utf-8"
# ref ：https://blog.csdn.net/weixin_39781462/article/details/82999610
# ref https://blog.csdn.net/qq_17550379/article/details/84110005
class Solution:
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        n = len(s)
        m = len(p)
        #############################
        ##########python二维数组坑！！！！！！！！！！！！！！！！############
        ############################
#         dp = [[False] *(m+1)]*(n+1)
#         print(dp)
#         dp[0][1] = True
#         print(dp)
        dp=[[False for j in range(len(p)+1)] for i in range(len(s)+1)]
        dp[0][0] =True
        for j in range(1,m+1):
            dp[0][j] = j>=2 and p[j-1]=="*" and dp[0][j-2] ==True
        
        for i in range(1,n+1):
            for j in range(1,m+1):
                if p[j-1]=="*":
                    dp[i][j] = dp[i][j-2] or (dp[i-1][j] and (s[i-1]==p[j-2] or p[j-2]==".")) 
         
                else:
                    dp[i][j] = (p[j-1]=="." or s[i-1]==p[j-1]) and dp[i-1][j-1]
        return dp[n][m]
print(Solution().isMatch("aa", "..."))



