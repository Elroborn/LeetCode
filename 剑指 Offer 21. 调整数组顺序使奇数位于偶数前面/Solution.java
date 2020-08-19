/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-19 10:52:38
 * @FilePath: \leetcode\剑指 Offer 21. 调整数组顺序使奇数位于偶数前面\Solution.java
 * @LastEditTime: 2020-08-19 10:58:56
 */
class Solution {
    public int[] exchange(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        int t = nums[0];
        int i = 0,j = nums.length - 1;
        while(i<j){
            while(i<j && nums[j]%2==0){
                j--;
            }
            nums[i] = nums[j];
            while(i<j && nums[i]%2!=0){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = t;
        return nums;

    }
}