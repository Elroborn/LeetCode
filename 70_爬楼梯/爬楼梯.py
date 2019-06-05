"""
Created on 2019/5/29 19:58
@File:爬楼梯.py
@author: coderwangson
"""
"#codeing=utf-8"

# http://www.sohu.com/a/149075950_684445
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n ==1:return 1
        if n==2:return 2
        f1 = 1
        f2 = 2
        for i in range(3,n+1):
            f = f1 + f2
            f1,f2 = f2,f
        return f
print(Solution().climbStairs(5))