"""
Created on 2019/4/7 20:35
@File:跳跃游戏 II.py
@author: coderwangson
"""
"#codeing=utf-8"

# may ref http://www.cnblogs.com/grandyang/p/4373533.html

class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        n = len(nums)
        cur = 0
        i = 0
        while cur<n-1:
            res+=1
            pre = cur
            while i<=pre:
                cur = max(cur,i+nums[i])
                i+=1
            if pre ==cur:return -1
        return res




print(Solution().jump([2,3,1,1,4]))



