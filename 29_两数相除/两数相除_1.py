"""
Created on 2019/3/11 19:41
@File:两数相除.py
@author: coderwangson
"""
"#codeing=utf-8"

# ref https://zhuanlan.zhihu.com/p/47708379
import math
class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        # 除法转为指数和对数减法
        if dividend ==0:
            return 0

        a = abs(dividend)
        b = abs(divisor)
        res = math.exp(math.log(a)-math.log(b))
        # ^ 异或 两个异号的话，两个条件肯定一个为假，一个为真 则异或为真
        if (divisor>0) ^ (dividend>0): res = -res
        if res >2**31-1: res = 2**31-1
        if res<-2**31: res = -2**31
        return int(res)

print(Solution().divide(-2147483648,1))


