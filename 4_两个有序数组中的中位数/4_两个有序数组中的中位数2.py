'''
Created on 2018年11月30日

@author: coderwangson
'''
"#codeing=utf-8"
# 112 ms
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # 中心扩散法
        # > ref https://blog.csdn.net/hk2291976/article/details/51107778
        # nums1是最短的那个
        n = len(nums1)
        m = len(nums2)
        if m<n:
            return self.findMedianSortedArrays(nums2,nums1)
        # 避免有个为空
        if n == 0:
            return  (nums2[m//2] +nums2[m//2 -(m+1)%2])/2.0
        left = 0
        # 加#扩展
        right = 2*n
        while left <=right:
            c1 = (left+right)//2
            c2 = (m+n) -c1
            l1 = float("-inf") if c1 ==0 else nums1[int((c1-1)//2)]
            r1 = float("inf") if c1 ==2*n else nums1[int((c1)//2)]
            l2 = float("-inf") if c2 ==0 else nums2[int((c2-1)//2)]
            r2 = float("inf") if c2 ==2*m else nums2[int((c2)//2)]
            if l1>r2:
                right = c1 -1
            elif l2>r1:
                left = c1+1
            else:
                break
        print(l1,l2)
        print(r1,r2)
        return (max(l1,l2)+min(r1,r2))/2.0
print(Solution().findMedianSortedArrays([1,2], [3,4]))       
        
        
        