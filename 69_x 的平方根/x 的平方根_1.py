"""
Created on 2019/5/24 16:04
@File:x 的平方根.py
@author: coderwangson
"""
"#codeing=utf-8"

# 超时
class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        i = 0
        while i<=x//2:
            if i*i <=x and (i+1)*(i+1)>x:
                break
            i+=1
        return i
print(Solution().mySqrt(4))