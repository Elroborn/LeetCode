/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-04 11:09:24
 * @FilePath: \leetcode\88_合并两个有序数组\Solution.java
 * @LastEditTime: 2020-07-04 11:18:00
 */ 
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //如果从左到右，则可能有用数据被覆盖，则从右往左，因为nums1右边都是0没有用
        int i = m - 1, j = n-1;
        int k = nums1.length - 1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        while(i>=0){
            nums1[k--] = nums1[i--];
        }
        while(j>=0){
            nums1[k--] = nums2[j--];
        }

    }
    public static void main(String[] args) {
        
      int[] nums1 =  {1,2,3,0,0,0};
      int m = 3;
      int[] nums2 =  {2,5,6};
      int n = 3;
      new Solution().merge(nums1, m, nums2, n);
      for(int i:nums1){
          System.out.println(i);
      }
    }
}