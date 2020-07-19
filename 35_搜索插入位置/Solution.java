/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-17 09:26:21
 * @FilePath: \leetcode\35_搜索插入位置\Solution.java
 * @LastEditTime: 2020-07-17 10:32:43
 */ 
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length -1;
        int mid = 0;
        while(left<=right){
            mid = left + (right - left) /2;
            if(nums[mid]==target){
                return mid;
            }else if(target<nums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(new Solution().searchInsert(nums, target));
    }
}