"""
Created on 2019/2/15 12:56
@File:三数之和.py
@author: coderwangson
"""
"#codeing=utf-8"
# ref http://www.cnblogs.com/grandyang/p/4481576.html 没整明白
#http://www.cnblogs.com/wmx24/p/8989800.html 没整明白
#http://www.cnblogs.com/voidsky/p/5490801.html 本代码参考的（就是那个pdf上的）
class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        # nums中三个数的和是0
        res = []
        nums = sorted(nums)
        left = 0
        l =len(nums)
        # left可以取所有的位置，和为0至少要有一个负数
        while left<l and nums[left]<=0:
            # 如果当前的和上个是一样的，那么跳过，因为会出现重复
            # 比如 [-1,-1,0,1,1]第一个-1能和后面0,1结成，同样第二个-1的组合会是一样的
            if left>0 and nums[left]==nums[left-1]:
                left += 1
                continue
            # 定义mid和right向中间计算
            mid = left+1
            right = l-1
            while mid<right:
                # 满足三个数的和为0
                if nums[mid]+nums[right]==0-nums[left]:
                    res.append([nums[left],nums[mid],nums[right]])
                    # 如果mid+1和mid一样，那么计算出来的结果一定同所以过滤掉
                    # 如 [0,0,0,0,0]
                    mid+=1
                    right-=1
                    while mid<right and nums[mid]==nums[mid-1]:mid+=1
                    while mid<right and nums[right]==nums[right+1]:right-=1
                elif nums[mid]+nums[right]<0-nums[left]:
                    mid+=1
                else:
                    right-=1
            left+=1
        return res
print(Solution().threeSum([-2,0,0,2,2]))