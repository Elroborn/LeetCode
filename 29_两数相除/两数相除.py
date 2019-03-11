"""
Created on 2019/3/11 19:41
@File:两数相除.py
@author: coderwangson
"""
"#codeing=utf-8"

# ref https://zhuanlan.zhihu.com/p/47708379
class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        # 转为移位运算
        a = abs(dividend)
        b = abs(divisor)
        res = 0
        # 如果a<b 则必定为0
        while a>=b:
            tmp = b
            cur = 1
            while a>(tmp<<1):
                tmp = tmp<<1
                cur=cur<<1
            a-=tmp
            res+=cur

        # ^ 异或 两个异号的话，两个条件肯定一个为假，一个为真 则异或为真
        if (divisor>0) ^ (dividend>0): res = -res
        if res >2**31-1: res = 2**31-1
        if res<-2**31: res = -2**31
        return res

print(Solution().divide(10,3))


