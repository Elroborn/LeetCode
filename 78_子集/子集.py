"""
Created on 2019/6/25 19:15
@File:子集.py
@author: coderwangson
"""
"#codeing=utf-8"
# 逐个法
# https://leetcode-cn.com/problems/subsets/solution/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        # 初始为空集，之后没增加一个nums中的数字，则把res的所有都append这个数字
        # 比如nums 1 2 3 ，初始res = [] 遍历到nums中的1则res ->[[],[1]]
        # 遍历到2 则res ->[[],[1],[2],[1,2]]
        res  = []
        res.append([])
        for i in nums:
            for j in range(len(res)):
                res.append(res[j]+ [i])

        return res

print(Solution().subsets([1,2,3]))
