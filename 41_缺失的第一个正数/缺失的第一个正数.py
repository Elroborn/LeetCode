"""
Created on 2019/3/28 22:09
@File:缺失的第一个正数.py
@author: coderwangson
"""
"#codeing=utf-8"
# ref https://blog.csdn.net/weixin_38823568/article/details/81360534
# 桶排序 你可以先用两个数组思考
# 现在就是把第一个数组里面的数据，向第二个数组里面进行桶排序，然后遍历桶排序完的，看哪个位置空，则说明是
# 而现在由于必须一个数组，所以就在一个数组上操作,并且把满足nums[i] = i+1 的进行填充（因为0的位置应该为1），使用交换两个数据的方法来操作
# 在交换时候注意https://leetcode-cn.com/problems/first-missing-positive/comments/  袁雷洋的分析

class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) ==0:
            return 1
        max = nums[0]
        for i in nums[1:]:
            if i>max:
                max = i
        nums_1 = [0 for i in range(max+2)]
        for i in nums:
            nums_1[abs(i)] = 1

        for i in range(1,len(nums_1)):
            if nums_1[i] ==0:
                return i


print(Solution().firstMissingPositive([0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0]))