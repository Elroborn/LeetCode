/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-06 10:34:05
 * @FilePath: \leetcode\494_目标和\Solution1.java
 * @LastEditTime: 2020-09-06 10:39:35
 */
class Solution1 {
    private static int cnt;
    public int findTargetSumWays(int[] nums, int S) {
        cnt = 0;
        dfs(nums,S,0,0);
        return cnt;
    }
    public void dfs(int[] nums,int S,int i,int sum){
        if(i==nums.length){
            if(sum==S){
                cnt++;
            }
            return ;
        }
        dfs(nums, S, i+1, sum+nums[i]);
        dfs(nums, S, i+1, sum-nums[i]);
        
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(new Solution1().findTargetSumWays(nums, 3));
    }
}