"""
Created on 2019/4/13 20:01
@File:Pow(x, n).py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n ==0:return 1
        half = self.myPow(x,n//2)
        if n%2 == 0:return half*half # 比如 2^4 = 2^2 * 2^2
        else: return half*half*x # 比如2^5 = 2^2*2^2 *2

print(Solution().myPow(3,2))