"""
Created on 19.9.18 21:01
@File:柱状图中最大的矩形.py
@author: coderwangson
"""
"#codeing=utf-8"
# 动态规划，自己写的，超时了

class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        if len(heights)==0:return 0
        d = [[0 for _ in heights] for _ in heights]
        max_v = max(heights)
        for i,j in enumerate(heights):
            d[i][i] = j
        for r in range(1,len(heights)): # 代表i-j之间距离按照斜线走的
            for i in range(0,len(heights)-r):
                j = i + r
                tmp = max(d[i][j-1],d[i+1][j],2*min(heights[i:j+1]))
                if tmp > max_v: max_v = tmp
                d[i][j] = tmp

        return max_v



print(Solution().largestRectangleArea([2,0,2]))