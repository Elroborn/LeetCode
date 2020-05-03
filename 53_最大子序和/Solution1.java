// https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
class Solution1 {
    public int maxSubArray(int[] nums) {
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
}