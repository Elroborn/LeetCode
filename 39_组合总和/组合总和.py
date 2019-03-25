"""
Created on 2019/3/25 20:36
@File:组合总和.py
@author: coderwangson
"""
"#codeing=utf-8"

# ref https://www.cnblogs.com/ariel-dreamland/p/9138630.html
import copy
class Solution(object):
    def dfs(self,start,candidates,target,out,res):
        # 不满足条件
        if target<0:
            return
        # 刚好满足
        if target ==0:
            res.append(copy.copy(out))
        # 从start开始遍历一遍，由于可以多个，所以是从start
        for i in range(start,len(candidates)):
            out.append(candidates[i])
            self.dfs(i,candidates,target - candidates[i],out,res)
            out.remove(candidates[i])

    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res = []
        out = []
        candidates = sorted(candidates)
        self.dfs(0,candidates,target,out,res)

        return res
print(Solution().combinationSum([2,3,6,7],7))
