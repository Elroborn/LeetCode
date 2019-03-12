"""
Created on 2019/3/12 20:35
@File:串联所有单词的子串.py
@author: coderwangson
"""
"#codeing=utf-8"
# : 2656 ms
# 相对而言 list的方法中not in 不如字典的，因为字典是hash的，所以空间换时间
# 而注意在变为dict的时候，key不能同，所以只能用 个数来表示了
import copy
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
        res = []
        # 从每个可能的起点遍历
        for i in range(len(s)-m*n+1):
            tmp_words = copy.copy(words)
            # 把字符串s 从i开始构造成n个长度为m的子串列表
            for j in range(n):
                if s[i + j * m:i + j * m + m] not in tmp_words:break
                tmp_words.remove(s[i + j * m:i + j * m + m])
            else:
                res.append(i)
        return res






print(Solution().findSubstring("barfoothefoobarman",["foo","bar"]))
