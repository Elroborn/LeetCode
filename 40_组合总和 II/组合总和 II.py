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
            if book[i] ==0 and candidates[i] not in candidates[:i]:
                book[i] =1
                out.append(candidates[i])
                self.dfs(i,book,candidates,target-candidates[i],out,res)
                book[i] = 0
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
