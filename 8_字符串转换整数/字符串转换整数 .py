'''
Created on 2018年12月9日

@author: coderwangson
'''
"#codeing=utf-8"
#ref https://blog.csdn.net/qitong111/article/details/79851796
import re
class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        res = ''
        # ^代表开始 tmp是匹配结果，是一个数组
        tmp = re.findall('^[-+]?\d+',str.strip())
        if tmp:
            nums = tmp[0]
            if nums[0]=='-' or nums[0]=='+':
                res = nums[1:]
            else:
                res = nums
            res = int(res)
            if nums[0] =='-':
                #-0x80000000代表 2**31-1
                return max(-res,-0x80000000)
            return min(res,0x7FFFFFFF)
        else:
            return 0
            
print(Solution().myAtoi(""))    
            
            