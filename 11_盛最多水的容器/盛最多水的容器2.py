"""
Created on 2019/2/2 9:38

@author: coderwangson
"""
"#codeing=utf-8"
# ref https://www.cnblogs.com/wmx24/p/9043447.html
class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        area = 0
        i = 0
        j = len(height)-1
        while i<j:
            width = j-i
            high = min(height[i],height[j])
            newArea = width * high
            area = newArea if newArea>area else area
            if height[i]>height[j]:
                j-=1
            else:
                i+=1
        return area

print(Solution().maxArea([1,8,6,2,5,4,8,3,7]))

