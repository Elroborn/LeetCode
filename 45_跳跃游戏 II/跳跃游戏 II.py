"""
Created on 2019/4/7 20:35
@File:跳跃游戏 II.py
@author: coderwangson
"""
"#codeing=utf-8"

# may ref http://www.cnblogs.com/grandyang/p/4373533.html
# bfs 超时
#ref https://www.jianshu.com/p/1c3ba23a522e
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #先尝试用BFS做用list做队列
        q = []
        q.append(0)
        n = len(nums)
        res = 0
        # 标记每层的起始结点位置和最后结点位置
        firstNode = 0
        lastNode = 1
        while len(q)>0:
            # 弹出一个
            v = q.pop(0)
            firstNode+=1
            if v == n-1:
                return res
            if nums[v]>0:
                next_level = list(range(v+1,v+1+nums[v]))
                if (n-1) in next_level:
                    return res+1
                q.extend(next_level)
            if firstNode == lastNode:
                res +=1
                firstNode = 0
                lastNode = len(q)
        return -1

print(Solution().jump([2,3,1,1,4]))



