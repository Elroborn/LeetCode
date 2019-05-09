"""
Created on 2019/5/8 17:11
@File:不同路径.py
@author: coderwangson
"""
"#codeing=utf-8"
# https://zhuanlan.zhihu.com/p/48681725
# https://www.zhihu.com/question/26094736
import math
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        # 从所有的必须的步数中，找到多少中向右（或者向下的可能）也就是 $C_n^r$
        return int(math.factorial(m + n - 2) / math.factorial(m - 1) / math.factorial(n - 1))
print(Solution().uniquePaths(7,3))
