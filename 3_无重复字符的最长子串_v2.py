'''
Created on 2018年11月23日

@author: coderwangson
'''
"#codeing=utf-8"
# 60ms
# ref  https://blog.csdn.net/littlebai07/article/details/79100081
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
        while i <len(s):
            # 不重复的了
            if (s[i] not in dict):
                dict[s[i]] = i
                temLength +=1
            else:
                # 是和前面以前删除的重复了
                if dict[s[i]] +temLength <i:
                    temLength +=1
                # 真正重复了
                else:
                    maxLength =maxLength if(maxLength>temLength) else temLength
                    temLength = i - dict[s[i]]
                dict[s[i]] = i
            i+=1 
        return (maxLength if(maxLength>temLength) else temLength)
print(Solution().lengthOfLongestSubstring("abcabcbb"))