"""
Created on 2019/2/4 9:15

@author: coderwangson
"""
"#codeing=utf-8"

# ref https://blog.csdn.net/net_wolf_007/article/details/51770112
class Solution:
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        map ={'M':1000,'D':500,
              'C':100,'L':50,
              'X':10,'V':5,
              'I':1}
        res = 0
        i = 0
        while i<len(s):
            if i==len(s)-1 or map[s[i]]> map[s[i+1]]:
                # 一般右边都会比左边小
                res+=map[s[i]]
                # 如果右边比左边大则准备用减法做4 或者9
            else:
                res-=map[s[i]]
            i+=1
        return res

print(Solution().romanToInt('MCMXCIV'))



