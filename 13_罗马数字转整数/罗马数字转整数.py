"""
Created on 2019/2/4 9:15

@author: coderwangson
"""
"#codeing=utf-8"


class Solution:
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        nums = [1000,500,100,50,10,5,1]
        romans = ['M','D','C','L','X','V','I']
        res = 0
        i = 0
        # 减一是防止最后一个溢出
        while i<len(s)-1:
            l = romans.index(s[i])
            k = romans.index(s[i+1])
            t =l -k
            if t ==1 or t ==2:
                res +=(nums[k]-nums[l])
                i+=2
            else:
                res+=nums[l]
                i+=1
        if i<len(s):
            return res+nums[romans.index(s[-1])]
        # 可能结尾是IV，其实V已经算了
        else:
            return res
print(Solution().romanToInt('MCMXCIV'))



