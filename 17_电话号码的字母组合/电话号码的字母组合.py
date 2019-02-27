"""
Created on 2019/2/26 18:59
@File:电话号码的字母组合.py
@author: coderwangson
"""
"#codeing=utf-8"

m = {"1": "", "2": "abc", "3": "def", "4": "ghi",
     "5": "jkl", "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}
class Solution(object):


    def dfs(self,i, tmp, digits,res):
        if i == len(digits):
            res.append(tmp)
            return
        for l in m[digits[i]]:
            Solution().dfs(i + 1, tmp + l, digits,res)
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        res =[]
        if len(digits)==0:
            return res
        else:
            Solution().dfs(0,"",digits,res)
            return res
print(Solution().letterCombinations("23"))
