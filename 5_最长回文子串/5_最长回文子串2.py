'''
Created on 2018年11月27日

@author: coderwangson
'''
"#codeing=utf-8"
class Solution(object):
    
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        #动态规划 
        #ref https://www.cnblogs.com/mini-coconut/p/9074315.html
        length = len(s)
        #最长子串开始位置
        start = 0
        #最长子串长度  --所以最长子串为 s[start,longest]
        longest = 1
        d = [[0]*length for i in range(length)]
        for i in range(length):
            d[i][i] = 1
            if i+1 <length:
                if s[i] ==s[i+1]:
                    d[i][i+1] =1
                    start = i
                    longest = 2
        # 构造数组右三角，按对角线构造
        for l in range(3,length+1):
            for i in range(0,length+1-l):
                j = i+l-1
                if s[i] == s[j] and d[i+1][j-1]:
                    d[i][j] = 1
                    start = i
                    longest = l
        return s[start:start+longest]
print(Solution().longestPalindrome("ccc"))      
        
