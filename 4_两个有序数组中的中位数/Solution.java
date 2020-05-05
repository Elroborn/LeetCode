class Solution {
    // 顺序遍历一遍即可，找到 len/2的位置，不是最优
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int p1 = 0,p2 = 0;
        int l1=0,l2=0;
        int ll = -1;
         //遍历也就是合并数组的思路，直到len/2个
         while(l1<nums1.length && l2<nums2.length){
             p1 = p2;
             if(nums1[l1]<nums2[l2]){
                 p2 = nums1[l1++];
             }else{
                 p2 = nums2[l2++];
             }
             ll++;
             if(ll==len/2){
                 return len%2==0?(p1+p2)/2.0:p2;
             }
         }
         while(l1<nums1.length){
            p1 = p2;
            p2 = nums1[l1++];
            ll++;
             if(ll==len/2){
                 return len%2==0?(p1+p2)/2.0:p2;
             }
         }
         while(l2<nums2.length){
            p1 = p2;
            p2 = nums2[l2++];
            ll++;
             if(ll==len/2){
                 return len%2==0?(p1+p2)/2.0:p2;
             }
         }
         return -1;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2},nums2 = {3,4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}