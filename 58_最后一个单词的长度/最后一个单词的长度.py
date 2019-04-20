class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        l = 0
        i = len(s) - 1 # 最后一个位置
        # 找到最右边不为' '的
        while i>=0 and s[i]==' ':
            i-=1
        # 找到最后一个单词的头部
        while i>=0 and s[i]!=' ':
            l+=1
            i-=1
        return l

print(Solution().lengthOfLastWord("a b "))