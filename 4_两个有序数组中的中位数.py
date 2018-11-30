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
        import sys
        n = len(nums1)
        m = len(nums2)
        if m<n:
            return self.findMedianSortedArrays(nums2,nums1)
        
        # 先把扩充加# 虚拟的，则第一个数组长度变为2*n+1 最后一个位置是2n
        l1 =0
        h1 = 2*n
        while l1<h1:
            #第一个数组的割在（l1+h1）/2 在扩充的数组中
            c1 = (l1+h1)/2
            # 由于是中值，则第二个割值在(2m+2n+2 /2 -c1-1)
            c2 = m+n - c1
            # 再把c1 c2映射会原位置
            nl_loc = int((c1-1)/2)
            nr_loc = int((c1)/2)
            L1 = float('-inf') if nl_loc==0 else nums1[nl_loc]
            R1 = float('inf') if nr_loc==2*n else nums1[nr_loc]
            nl_loc = int((c2-1)/2)
            nr_loc = int((c2)/2)
            L2 = float('-inf') if nl_loc==0 else nums2[nl_loc]
            R2 = float('inf') if nr_loc==2*m else nums2[nr_loc]
            if L1>R2:
                hi = c1-1
            elif L2>R1:
                lo = c1+ 1
            else:
                break
            
        return (max(L1,L2) +min(R1,R2))/2.0
print(Solution().findMedianSortedArrays([1,3], [2]))       
        
        
        