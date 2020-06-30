/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-06-30 09:26:08
 * @FilePath: \leetcode\268_缺失数字\Solution.java
 * @LastEditTime: 2020-06-30 09:28:33
 */ 
class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        res^=nums.length;
        for(int i=0;i<nums.length;i++){
            res^=(nums[i]^i);
        }
        return res;
    }
}