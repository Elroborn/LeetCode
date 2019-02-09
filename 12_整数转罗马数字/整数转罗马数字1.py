"""
Created on 2019/2/2 10:12

@author: coderwangson
"""
"#codeing=utf-8"

#ref  https://www.cnblogs.com/grandyang/p/4123374.html
class Solution:
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        roman =['M','D','C','L','X','V','I']
        nums =[1000,500,100,50,10,5,1]
        res =''
        # 按照10这类去找，分为1-3  4 5-8 9 四类，而5开头的放在5-8之间
        for i in range(0,len(nums),2):
            x = num//nums[i]
            # 如果当前不够，比如当前num是200，但是开始是除1000，则为0所以不影响
            if x<4:
                res+=(roman[i]*x)
            if x==4:
                res+=roman[i]+roman[i-1]
            if x==5:
                # 算5的那部分
                res+=roman[i-1]
            if x>5 and x<9:
                # 多于5的那部分
                res+=(roman[i-1]+roman[i]*(x-5))
            if x==9:
                res+=roman[i]+roman[i-2]
            num = num%nums[i]
        return res
print(Solution().intToRoman(1485))