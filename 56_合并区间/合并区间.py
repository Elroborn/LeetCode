"""
Created on 2019/4/19 20:31
@File:合并区间.py
@author: coderwangson
"""
"#codeing=utf-8"


# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    def inter(self,i,s):
        if i.start <s.start:
            letf = i
            right = s
        else:
            left = s
            right = i
        if left.end >= right.start:
            i.start = left.start
            i.end = max(left.end,right.end)
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
        print(i.start,'-',i.end)
l = []
s = Interval(1,4)
l.append(s)
s = Interval(4,5)
l.append(s)

show(Solution().merge(l))