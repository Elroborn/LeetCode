"""
Created on 2019/5/19 10:42
@File:加一.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        i = len(digits)-1
        count = 1 # 进位
        while i>=0:
            tmp = digits[i]+count
            digits[i] = tmp % 10
            count = tmp // 10
            i-=1
        if count>0:
            digits.insert(0,count)
        return digits

print(Solution().plusOne([]))