'''
Created on 2018年11月27日

@author: coderwangson
'''
"#codeing=utf-8"

class Solution(object):
    def check(self,s,start,end):
        i,j = start,end
        while(i<j):
            if s[i] !=s[j]:
                return ""
            i+=1
            j-=1
        return s[start:end+1]
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        # 最短也是一个
        best = s[0] if s!="" else ""
        dict = {}
        for i in range(len(s)):
            if s[i] not in dict:
                dict[s[i]] = [i]
            else:
                for start in dict[s[i]]:
                    temp = self.check(s,start,i)
                    if len(temp)>len(best):
                        best = temp
                dict[s[i]].append(i)
        return best
                     
print(Solution().longestPalindrome("abcda"))      
        
