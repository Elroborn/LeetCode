"""
Created on 2019/3/31 11:19
@File:接雨水.py
@author: coderwangson
"""
"#codeing=utf-8"
# ref https://www.cnblogs.com/felixfang/p/3713197.html

class Solution:
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height)<=2:
            return 0

        maxIndex = height.index(max(height))
        area = 0

        root = height[0]
        for i in range(0,maxIndex):
            if height[i]>root : root = height[i]
            else: area += (root - height[i])

        root = height[len(height)-1]
        for i in reversed(range(maxIndex,len(height))):
            if height[i]>root : root = height[i]
            else: area += (root - height[i])
        return area


print(Solution().trap([0,1,0,2,1,0,1,3,2,1,2,1]))
