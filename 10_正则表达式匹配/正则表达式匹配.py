'''
Created on 2018年12月21日

@author: coderwangson
'''
"#codeing=utf-8"
# ref ：https://blog.csdn.net/hk2291976/article/details/51165010
class Solution(object):
    @staticmethod
    def myMatch(s,i,p,j):
        if j==-1:
            if i ==-1:
                return True
            else:
                return False
        # 当为* 的时候，看*前面的值是否和s[i]匹配，因为我们是从后往前遍历的
        if p[j] =="*":
            if i>-1 and (p[j-1]=="." or (p[j-1] ==s[i])):
                if Solution.myMatch(s,i-1,p,j):
                    return True
            # 证明重复过了，可以跳过了如 add  和ad*当匹配到a的时候，需要调到a
            return Solution.myMatch(s,i,p,j-2)
        if i>-1 and (p[j] =="." or (p[j] ==s[i])):
            return Solution.myMatch(s,i-1,p,j-1)
        return False
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        return Solution.myMatch(s, len(s)-1, p, len(p)-1)       
print(Solution().isMatch("", "a"))


