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
        # 模拟栈
        l = []
        start = 0
        maxlen = 0
        for i in range(len(s)):
            if s[i] =='(':
                l.append(i)
            else:
                if len(l) ==0:
                    start = i+1
                else:
                    tmp = l.pop()
                    if len(l) ==0:
                        maxlen = max(i-start+1,maxlen)
                    else:
                        maxlen = max(i-l[-1],maxlen)
        return maxlen



print(Solution().longestValidParentheses("()()()((()()"))