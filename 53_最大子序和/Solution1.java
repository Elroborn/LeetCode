/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-05-03 09:33:43
 * @FilePath: \leetcode\53_最大子序和\Solution1.java
 * @LastEditTime: 2020-07-19 10:46:19
 */ 
// https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
class Solution1 {
    public int maxSubArray1(int[] nums) {
        int sum = 0,ans = nums[0];
        for(int i=0;i<nums.length;i++){
            if(sum>0){
                sum+=nums[i];
            }else{
                sum = nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
    public int maxSubArray(int[] nums) {
        int[] pre_sum = new int[nums.length+1];
        int res = Integer.MIN_VALUE;
        pre_sum[0] = 0;
        for(int i=1;i<=nums.length;i++){
            pre_sum[i] = pre_sum[i-1] + nums[i-1];
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                res = Math.max(res, pre_sum[j+1] -pre_sum[i]);
            }
        }
        return res;
    }
}