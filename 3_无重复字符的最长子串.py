'''
Created on 2018年11月23日

@author: coderwangson
'''
"#codeing=utf-8"
# 784ms
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        dict = {}
        maxLength = 0
        temLength = 0
        i = 0
        while i<len(s):
            if s[i] in dict:
                i = dict[s[i]]
                if temLength>maxLength:
                    maxLength = temLength
                dict = {}
                temLength = 0
            else:
                dict[s[i]] = i
                temLength+=1
            i+=1
        return (maxLength if(maxLength>temLength) else temLength)
print(Solution().lengthOfLongestSubstring("pwwkew"))