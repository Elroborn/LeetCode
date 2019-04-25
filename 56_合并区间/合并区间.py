"""
Created on 2019/4/19 20:31
@File:合并区间.py
@author: coderwangson
"""
"#codeing=utf-8"


# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self[0] = s
        self[1] = e
# ！！！！！！这个方法错了

# [[1,4],[0,2],[3,5]]
# 输出
# [[1,5],[0,2]]
# 预期结果
# [[0,5]]
class Solution(object):
    def inter(self,i,s):
        left =[]
        right = []
        if i[0] <s[0]:
            letf = i
            right = s
        else:
            left = s
            right = i
        if left[1] >= right[0]:
            i[0] = left[0]
            i[1] = max(left[1],right[1])
            return True
        else:
            return False
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        res = []
        while len(intervals)>0:
            s = intervals.pop()
            for i in res:
                if self.inter(i,s): # 判断是否交，如果交 在inter里面更新i
                    break
            else:
                res.append(s)
        return res
def show(l):
    for i in l:
        print(i[0],'-',i[1])
l = []
s = Interval(1,4)
l.append(s)
s = Interval(4,5)
l.append(s)

show(Solution().merge(l))