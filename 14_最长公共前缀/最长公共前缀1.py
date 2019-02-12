"""
Created on 2019/2/12 17:54
@File:最长公共前缀.py
@author: coderwangson
"""
# 直接法
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
            # 如果不是公共的前缀，则stemp在strs中索引不是第0个
            while strs[i].find(stemp)!=0:
                # 那么我们把stemp依次缩短
                stemp = stemp[:-1]
                if stemp=="":
                    return stemp
            i+=1
        return stemp


print(Solution().longestCommonPrefix(["flower","flow","flight"]))
