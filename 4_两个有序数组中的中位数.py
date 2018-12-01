'''
Created on 2018年11月30日

@author: coderwangson
'''
"#codeing=utf-8"
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # > ref https://blog.csdn.net/hk2291976/article/details/51107778
        # nums1是最短的那个
        n = len(nums1)
        m = len(nums2)
        if m<n:
            return self.findMedianSortedArrays(nums2,nums1)
        # 避免有个为空
        if n == 0:
            return  (nums2[m//2] +nums2[m//2 -(m+1)%2])/2.0
        L1 = n//2
        R1 = L1+1
        L2 = (m+n)//2 - (L1+1)-1
        R2 = L2+1
        L1_v = nums1[L1] if L1>-1 else float("-inf")
        R1_v = nums1[R1] if R1<n else float("inf")
        L2_v = nums2[L2] if L2>-1 else float("-inf")
        R2_v = nums2[R2] if R2<m else float("inf")
        while L1_v >R2_v or L2_v>R1_v:
            if L1_v >R2_v:
                L1 = L1 -1
                R1 = R1-1
                R1_v = L1_v
                L1_v = nums1[L1] if L1>-1 else float("-inf")
                L2 = L2+1
                R2 = R2 +1
                L2_v = R2_v
                R2_v = nums2[R2] if R2<m else float("inf")
            else:
                L2 = L2 -1
                R2 = R2 -1
                R2_v = L2_v
                L2_v = nums2[L2] if L2>-1 else float("-inf")
                L1 = L1+1
                R1 = R1+1
                L1_v = R1_v
                R1_v = nums1[R1] if R1<n else float("inf")
        if (m+n) %2 !=0:
            return min(R1_v,R2_v)
        else:
            return (max(L1_v,L2_v)+min(R1_v,R2_v))/2.0
        
print(Solution().findMedianSortedArrays([1,2], [3,4]))       
        
        
        