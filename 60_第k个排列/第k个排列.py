"""
Created on 2019/4/27 21:14
@File:第k个排列.py
@author: coderwangson
"""
"#codeing=utf-8"
import copy
# https://segmentfault.com/a/1190000018246661
class Solution(object):

    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        nums = [str(i) for i in range(1,n+1)]
        if k==1:
            return "".join(nums)
        fact = 1
        for i in range(1,n):
            fact *=i # (n-1) !
        round = n - 1 # 轮数
        k -= 1 # 因为数据是从1开始，索引是从0开始，为了统一 -=1
        finalRes = []
        while round >= 0:
            index = int(k / fact)
            k %= fact
            finalRes.append(nums[index])
            nums.remove(nums[index])
            if round > 0:
                fact /= round
            round -= 1
        return "".join(finalRes)

print(Solution().getPermutation(4,2))

