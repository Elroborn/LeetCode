"""
Created on 2019/2/2 9:38

@author: coderwangson
"""
"#codeing=utf-8"

class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        area = 0
        for i in range(len(height)):
            for j in range(i+1,len(height)):
                width = j-i
                high = min(height[i],height[j])
                area = width * high if (width*high)>area else area
        return area

print(Solution().maxArea([1,8,6,2,5,4,8,3,7]))

