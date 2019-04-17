"""
Created on 2019/4/16 21:47
@File:最大子序和.py
@author: coderwangson
"""
"#codeing=utf-8"
# ref https://blog.csdn.net/zwzsdy/article/details/80029796

# 动态规划 用了一个数组 其实数组可以不用的
# 用sums[i]表示以第i个为结尾（所以最后一个元素一定是a[i]）的连续子数组的最大和
# 则sums[i] = max(nums[i],sums[i-1]+nums[i]) 可以看出其实就是比较nums[i]是否大于0 ，所以sums数组其实可以不要
class Solution(object):
    def maxSubArray_with_sums(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sums = []
        max_sum = nums[0]
        sums.append(nums[0]) # sums[0] = nums[0]
        for i in range(1,len(nums)):
            t = max(sums[i-1]+nums[i],nums[i])
            if t>max_sum:
                max_sum = t
            sums.append(t)
        return max_sum
    # 不用sums数组
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_sum = nums[0]
        sums = nums[0] # 把sums看做sums[i-1]因为只需要sums[i-1]的信息
        for i in range(1,len(nums)):
            t = max(sums+nums[i],nums[i])
            if t>max_sum:
                max_sum = t
            sums = t
        return max_sum

print(Solution().maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))



