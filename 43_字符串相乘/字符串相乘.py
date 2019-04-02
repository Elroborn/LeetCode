"""
Created on 2019/4/2 21:37
@File:字符串相乘.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def calc(self,x,y):
        m = len(x)//2
        n = len(y)//2
        if len(x) ==0 or len(y) ==0:
            return 0
        if m ==0 and n==0:
            return int(x)*int(y)

        tmp_m_10 = 1
        tmp_n_10 = 1
        for i in range(len(x)-m):
            tmp_m_10 *=10
        for i in range(len(y)-n):
            tmp_n_10 *=10
        tmp_mn_10 = tmp_m_10 * tmp_n_10
        a = x[0:m]
        b = x[m:]
        c = y[0:n]
        d = y[n:]
        return tmp_mn_10*self.calc(a,c) + tmp_m_10 * self.calc(a,d) + tmp_n_10 * self.calc(b,c) + self.calc(b,d)
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        return str(self.calc(num1,num2))
print(Solution().multiply("121","15"))
