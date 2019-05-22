"""
Created on 2019/5/22 20:08
@File:二进制求和.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        res = ""
        la = len(a) - 1
        lb = len(b) - 1
        count = 0 # 进位
        while la>=0 and lb>=0:
            tmp = int(a[la]) + int(b[lb]) + count
            res = str(tmp%2) + res
            count = tmp//2
            la -=1
            lb -=1
        if la<0: # 都统一到a上面进行操作
            la = lb
            a = b
        while la>=0:
            tmp = int(a[la]) + count
            res = str(tmp % 2) + res
            count = tmp // 2
            la -= 1
        if count>0:
            res = str(count) + res

        return res

print(Solution().addBinary("10","11"))



