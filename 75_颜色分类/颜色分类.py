"""
Created on 2019/6/11 19:31
@File:颜色分类.py
@author: coderwangson
"""
"#codeing=utf-8"

# ref https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode/
class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        i,j = 0,len(nums)-1 # i代表0的右边界（nums[i]!=0 nums[i-1]=0），j代表2的左边界
        curr = 0 # 当前遍历的位置
        while curr<=j:
            if nums[curr]==2:
                nums[curr],nums[j] = nums[j],nums[curr] # 把curr位置的元素和j换一下
                j-=1 # 换完因为nums[j]=2 所以边界左移
            elif nums[curr]==0:
                nums[curr], nums[i] = nums[i], nums[curr]
                i+=1 # 边界右移
                curr+=1 # 因为curr是从i那边过来的，所以交换过的curr也不可能为2了，所以curr可以直接右移了
            else:
                curr+=1 # 如果上面进行了交换数据，不能移动curr如[1,2,0] 只有不交换数据才能移动
                # 因为移动后当前的元素内容变了

        print(nums)
Solution().sortColors([0])
