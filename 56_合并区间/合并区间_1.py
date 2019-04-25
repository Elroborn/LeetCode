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

class Solution(object):

    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        if intervals ==[]:return []
        # 先排序
        intervals.sort(key = lambda p:p[0])
        res = []
        tmp = intervals[0]
        for i in intervals:
            if tmp[1]>=i[0]:
                tmp[1] = max(i[1],tmp[1])
            else:
                res.append(tmp)
                tmp = i
        res.append(tmp)
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