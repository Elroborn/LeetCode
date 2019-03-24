"""
Created on 2019/3/24 9:36
@File:报数.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):

    def decode(self,s):
        res = ''
        l = len(s)
        i = 0
        t = 1
        while i<l:
            if i+1<l and s[i]==s[i+1]:
                t+=1
                i+=1
            else:
                res+=(str(t)+s[i])
                i +=1
                t = 1
        return res
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        # 找最简单的
        if n==1:
            return "1"
        if n ==2:
            return "11"
        # 如果找5-> 其实就是先找到4的，然后把4按照报数解码即可，所以递归
        return self.decode(self.countAndSay(n-1))

print(Solution().decode("1211"))