"""
Created on 2019/3/16 9:20
@File:最长有效括号.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) ==0:
            return 0
        # 如果第一个是 ( 的
        for i in range(len(s)):
            if s[i] =="(":
                break
        j = 0
        for k in range(i,len(s)):
            j = j +1 if s[k]=="(" else j-1
            if j<0:break
        return k-i-abs(j)+1

print(Solution().longestValidParentheses("((((((()"))