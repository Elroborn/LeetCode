"""
Created on 2019/3/10 13:59
@File:实现strStr().py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if len(needle) ==0:
            return 0
        for i in range(len(haystack)):
            if haystack[i] ==needle[0]:
                if haystack[i:i+len(needle)] == needle:
                    return i
        return -1

print(Solution().strStr("",""))