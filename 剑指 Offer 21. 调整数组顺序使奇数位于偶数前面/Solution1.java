/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-11-02 10:12:03
 * @FilePath: \leetcode\剑指 Offer 21. 调整数组顺序使奇数位于偶数前面\Solution1.java
 * @LastEditTime: 2020-11-02 10:17:30
 */
class Solution {
    public int[] exchange(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        int p = nums[0];
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
        nums[i] = p;
        return nums;
    }
}