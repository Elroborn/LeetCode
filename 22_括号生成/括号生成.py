"""
Created on 2019/3/2 20:26
@author: coderwangson
"""
#ref https://blog.csdn.net/w8253497062015/article/details/80001249
# TODO 没写md
class Solution(object):
    def dfs(self,cur,left,right,res):
        if left==0 and right ==0:
            cur+=""
            res.append(cur)
            return
        else:
            if left>0:
                self.dfs(cur+"(",left-1,right,res)
            if left<right:
                self.dfs(cur+")",left,right-1,res)

    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        res =[]
        self.dfs("",n,n,res)
        return res
print(Solution().generateParenthesis(1))
