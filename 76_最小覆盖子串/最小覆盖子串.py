"""
Created on 2019/6/24 19:55
@File:最小覆盖子串.py
@author: coderwangson
"""
"#codeing=utf-8"
#ref https://blog.csdn.net/weixin_41958153/article/details/81623474

class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        left,right= 0,0
        minLen = len(s)+1 # 初始化的时候为最大，这样后面能更新
        m = {}
        res = ""
        for i in t:
            m[i] = m.get(i,0) + 1# 因为只是要统计t中出现字符，不需要顺序一致，所以可以用hash存储
        # 开始滑动窗口先找右，再滑动左
        count = 0 # 表示t中有多少个在s中，不包括s中多的重复的
        while right<len(s):
            if s[right] in m:
                m[s[right]] -=1 # 匹配掉了
                if m[s[right]]>=0:# 必须要>=0  比如 ABBBC 和ABC 当匹配到第一个B的时候count需要+=1，但是第二个的时候m["B"] = -1此时不需要count+=1了，因为重复了
                    count+=1
                while count == len(t): # 说明这个窗口里面包含了所有
                    if right -left + 1<minLen:
                        minLen = right -left + 1
                        res = s[left:right+1]
                    if s[left] in m: # 滑动left之前先看这个被滑动的是不是会影响count
                        m[s[left]] +=1
                        if m[s[left]] > 0 : # 说明滑动到了最后一个，把之前囤积的都滑动没了,对count更新
                            count -=1
                    left +=1
            right +=1
        return res


print(Solution().minWindow("a","aa"))