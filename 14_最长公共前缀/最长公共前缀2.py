"""
Created on 2019/2/12 17:54
@File:最长公共前缀.py
@author: coderwangson
"""
# 水平扫描 想象数组的末尾有一个非常短的字符串， 使用上述方法依旧会进行S次比较。
# 优化这类情况的一种方法就是水平扫描。 我们从前往后枚举字符串的每一列，先比较每个字符串相同列上的字符（即不同字符串相同下标的字符）然后再进行对下一列的比较。
#TODO 水平扫描法
"#codeing=utf-8"
class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs)==0:
            return ""
        if strs[0]=="":
            return ""
        sprefix = ""
        stemp = strs[0][0]
        while True:
            for i in strs:
                if i.find(stemp)!=0:
                    return sprefix


        return stemp


print(Solution().longestCommonPrefix(["flower","flow","flight"]))
