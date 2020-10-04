/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-04 10:59:00
 * @FilePath: \leetcode\剑指 Offer 03. 数组中重复的数字\Solution1.java
 * @LastEditTime: 2020-10-04 11:21:21
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                //顺序注意， 因为nums[i] 要被用，所以最后换
                int t = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = t;
            }
        }
        return -1;
    }
}