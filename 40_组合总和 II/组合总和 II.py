"""
Created on 2019/3/26 22:03
@File:组合总和 II.py
@author: coderwangson
"""
"#codeing=utf-8"
import copy
class Solution(object):
    def dfs(self,start,book,candidates,target,out,res):
        if target<0:
            return
        if target ==0:
            res.append(copy.copy(out))
        for i in range(start,len(candidates)):
            # book[i]是为了避免某个位置的重复
            # candidates[i] not in candidates[:i]是为了避免在前面的数据中重复
            if candidates[i] not in candidates[:i]:
                # book[i] =1
                out.append(candidates[i])
                self.dfs(i+1,book,candidates,target-candidates[i],out,res)
                # book[i] = 0
                out.remove(candidates[i])
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        book = [0 for i in candidates]

        out = []
        res = []
        candidates = sorted(candidates)
        self.dfs(0,book,candidates,target,out,res)
        return res

print(Solution().combinationSum2([10,1,2,7,6,1,5],8))


# class Solution:
#     def __init__(self):
#         self.result = []
#
#     def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
#         # 排序是 防止出现[1,7],[7,1]这样的重复
#         candidates.sort()
#         self.getResult(candidates, target, [])
#         return self.result
#
#     def getResult(self, nums, target, buff):
#         if target == 0:
#             self.result.append(list(buff))
#         for i in range(len(nums)):
#             if nums[i] > target or nums[i] in nums[:i]:
#                 continue
#             buff.append(nums[i])
#             self.getResult(nums[i + 1:], target - nums[i], buff)
#             buff.pop()
#         return
