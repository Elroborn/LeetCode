"""
Created on 2019/5/26 14:15
@File:文本左右对齐.py
@author: coderwangson
"""
"#codeing=utf-8"
#ref https://blog.csdn.net/qq_17550379/article/details/85013613
class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        if not words: # 如果words是None或者[]
            return []
        res,row =[],[]
        l = 0
        i = 0
        while i<len(words):
            if len(words[i]) + l<=maxWidth: # 如果之前的长度加上当前的单词不超过max
                l +=(len(words[i])+1) # 要了的话后面补一个空格(+1)，为了和下一个单词分开
                row.append(words[i])
                i+=1
                continue
            else: # 当前加上第i个位置的单词words[i]超过了max,则把row里面的进行整理
                if len(row)==1: # 只有一个的话，直接右边全补空
                    res.append(str(row[0])+' '*(maxWidth-len(row[0])))
                else:# >=2个单词
                    total_space = maxWidth -(l- len(row)) #看总共应该插入多少个空格，因为l中本身每个单词后面是带的有空格的，所以要先-len(row)
                    word_space = total_space //(len(row)-1) #每个单词均分几个空格
                    more_space = total_space %(len(row)-1) # 均分后还多出来的空格（都放到左边，因为题目中说了左侧放的要多余右侧）
                    tmp = ''
                    for word in row[:-1]:
                        if more_space >0:
                            tmp +=str(word)+' '*(word_space + 1) # 1就是从more_space里面拿的，因为多的都放在左边，所以每个左边的单词都多拿一个
                            more_space -=1
                        else:
                            tmp += str(word) + ' ' * (word_space) # 相当于more_space用完了，相当+0

                    tmp +=str(row[-1]) # 每行最后一个单词最后没有空格
                    res.append(tmp)
                row = []
                l = 0


        # 最后一行---当i访问到最后一个单词的时候
        tmp = ' '.join(row) # 单词之间用' '隔开即可
        res.append(tmp + (maxWidth - len(tmp))*' ') # 后面补空格

        return res





