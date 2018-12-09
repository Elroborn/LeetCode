'''
Created on 2018年12月9日

@author: coderwangson
'''
"#codeing=utf-8"
class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        s = str(x)
        s1 = s[::-1]
        if s==s1:
            return True
        else:
            return False
print(Solution().isPalindrome(121))