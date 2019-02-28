"""
Created on 2019/2/28 18:54
@File:有效的括号.py
@author: coderwangson
"""
"#codeing=utf-8"


class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        l = []
        for i in s:
            if i in ['(','[','{']:
                l.append(i)
            else:
                if len(l)>0:
                    c =l.pop()
                else:
                    return False
                if (i ==')' and c=='(') or (i==']' and c=='[') or (i=='}' and c=='{'):
                    continue
                else:
                    return False
        return len(l)==0

print(Solution().isValid("]"))

