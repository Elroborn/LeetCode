/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-20 11:17:22
 * @FilePath: \leetcode\213_打家劫舍 II\Solution.java
 * @LastEditTime: 2020-08-20 11:28:05
 */
class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length ==0){
            return 0;
        }
        if(nums.length ==1){
            return nums[0];
        }
        //分解成两个打家劫舍1，即 1-n-1 和2 - n 这样避免了头尾相连
        int _1_n_1 = rob(nums,0,nums.length - 2);
        int _2_n = rob(nums,1,nums.length - 1);
        return Math.max(_1_n_1, _2_n);
    }
    public int rob(int[] nums,int i,int j){
        int pre_2 = 0;
        int pre_1 = 0;
        for(int k = i;k<=j;k++){
            int t = Math.max(nums[k] + pre_2,pre_1); //把i 和i+1其实也隐性包含了
            pre_2 = pre_1;
            pre_1 = t;
        }
        return pre_1;
    }
}