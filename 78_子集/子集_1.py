"""
Created on 2019/6/25 19:15
@File:子集.py
@author: coderwangson
"""
"#codeing=utf-8"
# 二进制法
# https://leetcode-cn.com/problems/subsets/solution/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        # 刚好幂集是2^n 所以可以用二进制代表比如 0100代表第1个位置上面取
        res  = []
        for i in range(0,1<<len(nums)):# i相当于从 0000 - 1111
            tmp = []
            for j in range(0,len(nums)): # 现在有了i，每次遍历到j，只需要看i对应二进制在j位置是否为1
                if (i>>(j) & 1) ==1: # 用了小技巧，比如当前i为0100 遍历到的j = 1，那么i>>j为 0010 所以&1为0
                                            # 代表从右边第一位为0 （从0计数）
                    tmp.append(nums[j])
            res.append(tmp)
        return res

print(Solution().subsets([1,2,3]))
