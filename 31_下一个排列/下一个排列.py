"""
Created on 2019/3/14 20:00
@File:下一个排列.py
@author: coderwangson
"""
"#codeing=utf-8"
#ref https://leetcode-cn.com/problems/next-permutation/solution/
class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        # 如果用直接用i作为基准，那么需要判断i-1是否越过0，所以用i_1作为基准--
        # len(nums)-1 是最后一个下标
        i_1 = len(nums)-1 -1 # i_1 代表i-1
        if i_1 <0: # 因为如果就一个元素，下面反转时候切片会出问题，所以直接做个判断返回
            return None
        while i_1>= 0 and nums[i_1]>=nums[i_1+1]:
            i_1 -=1
        # 找到一个刚好比i_1大的值
        if i_1>=0:
            j = len(nums)-1
            while j>=0 and nums[j]<=nums[i_1]:
                j-=1
            nums[i_1],nums[j] = nums[j],nums[i_1]
        # 从i开始反转一下（变得小了） 这样才是下一个
        i = i_1 + 1
        nums[i:] =nums[:i-1:-1]
print(Solution().nextPermutation([1,2]))



