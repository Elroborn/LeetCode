"""
Created on 2019/4/7 20:27
@File:跳跃游戏.py
@author: coderwangson
"""
"#codeing=utf-8"
# ref http://www.cnblogs.com/grandyang/p/4371526.html

class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        reach = 0
        for i in range(len(nums)):
            if i>reach:break
            reach = max(reach,i+nums[i])

        return reach>=len(nums)-1
