"""
Created on 2019/4/13 19:33
@File:字母异位词分组.py
@author: coderwangson
"""
"#codeing=utf-8"
# 计数法，因为字母总共26个，用26个桶放在那里，然后遍历单个字符串比如abbc 对应到的码为(121000000)
# 这个码可以发现是唯一的，所以作为hash
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        res = {}
        for s in strs:
            c = [0]*26
            for i in s:
                c[ord(i)-ord('a')]+=1
            k = tuple(c)
            if res.get(k) ==None:
                res[k] = []
            res[k].append(s)
        return res.values()

print(Solution().groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))