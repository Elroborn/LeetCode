"""
Created on 2019/4/13 19:33
@File:字母异位词分组.py
@author: coderwangson
"""
"#codeing=utf-8"
# 用字典存储，eta 的键为('a','e','t')这样eat的键也为('a','e','t')
# 因为tuple可以hash
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        d =  {}
        for s in strs:
            k = tuple(sorted(s))
            if d.get(k) ==None:
                d[k] =[]
            d[k].append(s)
        return d.values()

print(Solution().groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))