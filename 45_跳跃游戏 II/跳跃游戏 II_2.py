"""
Created on 2019/4/7 20:35
@File:跳跃游戏 II.py
@author: coderwangson
"""
"#codeing=utf-8"

# https://www.jianshu.com/p/1c3ba23a522e
# 按照树
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        level = 0
        curMax = 0
        i = 0
        n = len(nums)
        if n <2 :return 0
        while curMax - i + 1 >0:
            level +=1
            tmp_curMax = curMax
            while i <=tmp_curMax:
                curMax = max(curMax,i+nums[i])
                i+=1
            if curMax >= n-1:
                return level
        return level
print(Solution().jump([2,1]))



