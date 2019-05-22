"""
Created on 2019/5/22 19:54
@File:有效数字.py
@author: coderwangson
"""
"#codeing=utf-8"
# https://blog.csdn.net/jhbxlx/article/details/38108785
class Solution(object):
    def isNumber(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = s.strip() #去空格
        n = len(s)
        if n==0:return False
        i = 0
        isNum = False # 当前0-i是否为有效数字
        hasE = False # 到当前位置是否有e出现（因为只能出现一次）
        hasDot = False # 到当前位置是否有.出现（因为只能出现一次）
        if s[i]=='-' or s[i]=='+':i=+1 # 开始的时候可能有正负号，先判断
        while i<n:
            if s[i]>='0' and s[i]<='9': isNum = True #是数字
            elif s[i]=='e':
                if not isNum or hasE:return False # 当前还没有数字（E不能出现在开头）或者已经有了E
                hasE = True
                isNum = False #如果出现E了，后面没有数字，则为False
            elif s[i]=='.':
                if hasDot or hasE:return False # .只能出现一次，并且不能在e后面，可以在e前面
                hasDot = True
            elif s[i]=='-' or s[i]=='+':
                if s[i-1]!='e':return False # 第一个代表正负号的加减刚开始已经过滤了，所以后面的+-只能是E后面的
            else:return False # 其他字符
            i+=1
        return isNum

print(Solution().isNumber("0e"))
