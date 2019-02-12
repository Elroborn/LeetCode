"""
Created on 2019/2/12 17:54
@File:最长公共前缀.py
@author: coderwangson
"""
# 分治法
"#codeing=utf-8"
class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs)==0:
            return ""
        stemp = strs[0]
        i =1
        while i<len(strs):
            stemp = self.twoCommonPrefix(stemp,strs[i])
            i+=1
        return stemp

    def twoCommonPrefix(self,str1,str2):
        i = 0
        while i<len(str1) and i<len(str2):
            if str1[i]!=str2[i]:
                break
            else:
                i+=1
        return str1[0:i]

print(Solution().longestCommonPrefix([]))
