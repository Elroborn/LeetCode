"""
Created on 19.9.18 21:01
@File:柱状图中最大的矩形.py
@author: coderwangson
"""
"#codeing=utf-8"

# 暴力法，遍历所有可能的柱子组合--00 01 02 03 11 12 13 22 23
class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """

        if len(heights)==0:return 0
        max_v = 0
        for i in range(len(heights)):
            min_height = float("inf")
            for j in range(i,len(heights)):
                min_height = min(min_height,heights[j])
                tmp = (j-i+1)*min_height
                if tmp > max_v:
                    max_v = tmp

        return max_v



print(Solution().largestRectangleArea([2,0,2]))