/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-01 09:53:16
 * @FilePath: \leetcode\486_预测赢家\Solution.java
 * @LastEditTime: 2020-09-01 10:43:21
 */
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return dfs(nums,0,nums.length-1,1)>=0;
    }
    public int dfs(int[] nums,int start,int end,int turn){
        if(start==end){
            return nums[start]*turn;
        }
        int start_score = nums[start]*turn + dfs(nums, start+1, end, -turn);
        int end_score = nums[end]*turn + dfs(nums, start, end-1, -turn);
        return Math.max(start_score*turn, end_score*turn)*turn;
    }
    public static void main(String[] args) {
        int[] nums = {1, 5,223,7};
        System.out.println(new Solution().PredictTheWinner(nums));
    }
}