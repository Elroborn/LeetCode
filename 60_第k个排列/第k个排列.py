"""
Created on 2019/4/27 21:14
@File:第k个排列.py
@author: coderwangson
"""
"#codeing=utf-8"
import copy
# https://segmentfault.com/a/1190000018246661
# https://blog.csdn.net/qq_17550379/article/details/84959851

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
        # k 是从1开始，而索引从0开始，所以k-=1
        # 比如 [1,2] 我们如果k = 1的话， 则k//1 = 1 k%1 = 1,可以发现将会以2开头，所以出错

        k -= 1
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

print(Solution().getPermutation(4,3))

