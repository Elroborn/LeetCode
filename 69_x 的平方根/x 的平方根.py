"""
Created on 2019/5/24 16:04
@File:x 的平方根.py
@author: coderwangson
"""
"#codeing=utf-8"

# 二分法
class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        left,right = 0,x
        while left<=right:
            mid = (left+right)//2
            if mid * mid >x:
                right = mid -1
            else:
                left = mid + 1
        return left-1
print(Solution().mySqrt(4))