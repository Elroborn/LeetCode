'''
Created on 2018年12月3日

@author: coderwangson
'''
"#codeing=utf-8"

class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        l = len(s)
        if numRows ==1:
            return s
        # 原先二维数组,但是由于二维数组过大，导致最后取出结果的时候超时
        #其实行直接用字符串更加方便，这样避免了取的时候再拼接
        z = ["" for i in range(numRows)]
        direction = 1
        m = 0
        # 规律就是从上往下到底，然后再回去
        for i in range(l):
            z[m]+=s[i]
            if m == 0:
                direction =1
            elif m ==numRows-1:
                direction = -1
            if direction ==1:
                m +=1
            else:
                m -=1
        return "".join(z)
print(Solution().convert("ABC", 2))    
