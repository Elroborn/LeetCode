"""
Created on 2019/4/13 20:01
@File:Pow(x, n).py
@author: coderwangson
"""
"#codeing=utf-8"

# ref http://www.cnblogs.com/grandyang/p/4383775.html
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n ==0:return 1
        half = self.myPow(x,abs(n)//2)
        res = 1
        if n%2 == 0:res = half*half # 比如 2^4 = 2^2 * 2^2
        else: res = half*half*x # 比如2^5 = 2^2*2^2 *2
        # 因为在python中 -1//2 = -1
        return res if n>0 else 1/res

print(Solution().myPow(2,-1))