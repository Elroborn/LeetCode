"""
Created on 2019/4/25 20:30
@File:插入区间.py
@author: coderwangson
"""
"#codeing=utf-8"
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
    def midSearch(self,intervals,newInterval):
        left = 0
        right = len(intervals)-1
        while left <=right:
            mid = (left + right)//2
            if intervals[mid][0] == newInterval[0]:
                return mid
            elif intervals[mid][0] <newInterval[0]:
                left = mid+1
            else:
                right = mid -1
        return right + 1

    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        if len(intervals)==0:
            return [newInterval]
        i = self.midSearch(intervals,newInterval)
        intervals.insert(i,newInterval)
        # 向后合并
        for tmp in intervals[i+1:]:
            if newInterval[1] < tmp[0]:
                break
            else:
                # 合并删除
                newInterval[1] = max(tmp[1],newInterval[1]) # 向后合并，只需要考虑end那个，因为start是已经排过序的
                intervals.remove(tmp)

        # 向前合并
        for tmp in intervals[-(len(intervals)-i+1)::-1]:
            if tmp[1] < newInterval[0]:
                break
            else:
                newInterval[1] = max(tmp[1],newInterval[1])
                newInterval[0] = tmp[0]# 需要更新下start，因为tmp的start肯定比new的小
                intervals.remove(tmp)
        return intervals

def show(l):
    for i in l:
        print(i[0],'-',i[1])
l = []
# s = Interval(1,2)
# l.append(s)
# s = Interval(3,5)
# l.append(s)
# s = Interval(6,7)
# l.append(s)
# s = Interval(8,10)
# l.append(s)
# s = Interval(12,16)
# l.append(s)
l = [[1,5]]
l1 = [2,3]


show(Solution().insert(l,l1))