/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-21 14:30:31
 * @FilePath: \leetcode\剑指 Offer 42. 连续子数组的最大和\Solution.java
 * @LastEditTime: 2020-08-21 14:41:45
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int tmp = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(tmp>0){ // 之前只要有贡献即可
                tmp = tmp + nums[i];
            }else{
                tmp = nums[i];
            }
            res = Math.max(res, tmp);
        }
        return res;

    }
    public static void main(String[] args) {
        int[] nums = {-2,1};
        System.out.println(new Solution().maxSubArray(nums));
    }
}