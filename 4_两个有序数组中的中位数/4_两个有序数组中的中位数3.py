'''
Created on 2018年11月30日

@author: coderwangson
'''
"#codeing=utf-8"
# 84 ms
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # O(min(m,n))
        # 就是找k个最小，一个一个找
        # > ref https://blog.csdn.net/hk2291976/article/details/51107778
        # nums1是最短的那个
        n = len(nums1)
        m = len(nums2)
        is_odd = (m+n)%2
        if m<n:
            return self.findMedianSortedArrays(nums2,nums1)
        # 避免有个为空
        if n == 0:
            return  (nums2[m//2] +nums2[m//2 -(m+1)%2])/2.0
        left = 0
        l1 = 0
        l2 = 0
        # 计算长度
        i = 0
        k = (m+n)//2+1
        topk = 0
        # 第k-1个
        topk_1 = 0
        #找topk
        while l1<n and l2<m:
            if nums1[l1] < nums2[l2]:
                topk_1 = topk
                topk = nums1[l1]
                l1+=1
            else:
                topk_1 = topk
                topk = nums2[l2]
                l2+=1     
            i+=1
            if i ==k:
                break
        # 都统一到nums1中
        if l2<m and i<k:
            l1 = l2
            nums1 =nums2
            n = m
        # 有一个没遍历完的话，就用加减法计算出来位置，这个写的不好
        if l1<n and i<k:
            topk_1 = topk
            topk = nums1[l1+(k-i-1)]
            topk_1 = topk_1 if l1+(k-i-1)-1<l1 else nums1[l1+(k-i-1)-1]
        if is_odd ==0:
            return (topk+topk_1)/2.0
        else:
            return topk
print(Solution().findMedianSortedArrays([1], [2,3,4]))       
        
        
        