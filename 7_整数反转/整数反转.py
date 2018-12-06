'''
Created on 2018年12月5日

@author: coderwangson
'''
"#codeing=utf-8"
class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        s = str(x)
        flag = s[0]
        if flag =="-":
            s = s[:0:-1]
            t = int(s)
            return -t if -t>=-2**31 else 0
        else:    
            s = s[::-1]
            t = int(s)
            return t if t<=2**31-1 else 0
        
print(Solution().reverse(1534236469))