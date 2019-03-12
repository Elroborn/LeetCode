"""
Created on 2019/3/12 20:35
@File:串联所有单词的子串.py
@author: coderwangson
"""
"#codeing=utf-8"
# ref https://www.cnblogs.com/grandyang/p/4521224.html
# 424 ms
class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        if s=="" or len(words)==0:
            return []
        n = len(words)
        m = len(words[0])
        map1 ={}
        res = []
        for i in words: map1[i] =1 if i not in map1 else map1[i]+1
        # 从每个可能的起点遍历
        for i in range(len(s)-m*n+1):
            map2 ={}
            for j in range(n):
                # 从字符串里面从起点依次取子串 看是否在字典map1中
                tmp = s[i+j*m:i+j*m+m]
                # 如果没有，则直接跳过，因为匹配不到的
                if tmp not in map1:break
                # 如果有，则先把用过的暂存到map2中，并且标记为1，这样下次再次使用的时候进行比较，如果>1，则说明使用了两次
                # 则跳过
                map2[tmp] =1 if tmp not in map2 else map2[tmp]+1
                # 说明使用了两次，则跳出
                if map2[tmp] >map1[tmp]: break
            # 说明没有break过
            else:
                res.append(i)
        return res






print(Solution().findSubstring("wordgoodgoodgoodbestword",["word","good","best","good"]))
