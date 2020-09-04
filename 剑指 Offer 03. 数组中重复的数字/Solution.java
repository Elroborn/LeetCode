/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-04 12:45:36
 * @FilePath: \leetcode\剑指 Offer 03. 数组中重复的数字\Solution.java
 * @LastEditTime: 2020-09-04 12:54:48
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
        //用nums做set，将所有i位置的数字也是i，因为所有数字都在0-n-1，所以刚好用nums做set
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=i){
                //把nums[i] 放到nums[i] 这个位置
                int j = nums[i]; //将nums[i] 放到j这个位置
                if(nums[j]==nums[i]){//看看是否已经被占用
                    return nums[i]; 
                }else{ //交换
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }

            }
        }
        return -1;

    }
}