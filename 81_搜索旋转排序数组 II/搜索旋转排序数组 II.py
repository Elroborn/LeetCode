"""
Created on 19.9.14 19:42
@File:搜索旋转排序数组 II.py
@author: coderwangson
"""
"#codeing=utf-8"
#ref https://blog.csdn.net/whdAlive/article/details/80432797
class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        # 进行旋转，其实就是变为了两个递增序列，所以我们如果进行二分，则
        # 有两种情况，一种是刚好在一个递增序列中，一种是跨了两个序列，我们
        # 主要处理在递增序列的情况
        # ----->---|-->
        # ----|--->--->
        start = 0
        end = len(nums) -1
        while start<=end:
            mid = (start+end)//2
            if nums[mid] == target:
                return True
            if nums[start] ==nums[mid]:# 解决1 3 1 1 1有问题 原来33题，关键在于确定一个有序，一个无序，但对于 1 3 1 1 1问题，会出现start == mid，但无序，所以先排除
                start +=1
                continue
            # 说明左半部分有序是递增，则先看target是否在左半边
            if nums[start]<nums[mid] :
                # 说明目标在左半递增的那边，就是正常二分，更新end
                if nums[start]<=target and target<nums[mid]:
                    end = mid-1
                # 说明不是在做半边递增那边
                else:
                    start = mid+1
            # 左半边无序的话，那么右半边一定有序，先看target是否在右半边
            else:
                #看target是否在右半边
                if nums[mid]<target and target<=nums[end]:
                    start = mid+1
                else:
                    end = 0 if mid-1<0 else mid-1

        return False

print(Solution().search([1,1,3,1],3))