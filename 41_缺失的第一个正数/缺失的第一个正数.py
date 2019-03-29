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
        length = len(nums)
        if length ==0:
            return 1
        for i in range(length):
            while nums[i]>0 and nums[i]!=i+1 and nums[i]<=length:
                index = nums[i] -1
                if nums[index] ==nums[i]:
                    nums[i] = 0
                    break
                t = (nums[index],nums[i])
                nums[i],nums[index] = t
        i = 0
        while i <length and nums[i]==i+1:
            i+=1
        return i+1

print(Solution().firstMissingPositive([3,4,-1,1]))