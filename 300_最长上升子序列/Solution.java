import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length]; //dp[i] 代表0-i 的最长上升子序列
        Arrays.fill(dp, 1); // 每个数至少会是 1
        for(int i=0;i<nums.length;i++){// 更新 dp[i] --> j从0-i如果nums[i]>nums[j] 则可以比较一下dp[j] + 1（+1 就是把nums[i]添加到序列里）
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]= Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int res = 0;
        for(int i=0;i<dp.length;i++){
            res = Math.max(res, dp[i]);
        }
        return res;

    }
}