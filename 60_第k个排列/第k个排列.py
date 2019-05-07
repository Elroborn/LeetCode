"""
Created on 2019/4/27 21:14
@File:第k个排列.py
@author: coderwangson
"""
"#codeing=utf-8"
import copy
# https://segmentfault.com/a/1190000018246661

# https://www.google.com.hk/search?q=%E7%AC%ACk%E4%B8%AA%E6%8E%92%E5%88%97&ie=utf-8
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
        k -= 1 # 对于取余来说比如我们现在对于n = 4 k =3的情况 那么很简单能确定
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

