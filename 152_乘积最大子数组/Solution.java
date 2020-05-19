class Solution {
    public int maxProduct1(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length==0){
            return -1;
        }
        dp[0] = nums[0];
        int res = dp[0];
        for(int i=1;i<nums.length;i++){
            int t = nums[i];
            dp[i] = nums[i];
            for(int j=i-1;j>=0;j--){
                t*=nums[j];
                dp[i] = Math.max(dp[i],t);
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
    public int maxProduct(int[] nums) {
        // 因为可能出现负数，而导致负负得正，所以保存一个最小值的dp，这样每次从dp_max[i-1]*nums[i] ,dp_min[i-1] * nums[i] 以及nums[i] 找即可
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];
        if(nums.length==0){
            return -1;
        }
        dp_max[0] = nums[0];
        dp_min[0] = nums[0];
        int res = dp_max[0];
        for(int i=1;i<nums.length;i++){
            dp_max[i] = Math.max(dp_max[i-1]*nums[i], Math.max(dp_min[i-1]*nums[i], nums[i]));
            dp_min[i] = Math.min(dp_max[i-1]*nums[i], Math.min(dp_min[i-1]*nums[i], nums[i]));
            res = Math.max(res,dp_max[i]);
        }
        return res;

    }
    public static void main(String[] args) {
        int[] nums = {2,-5,-2,-4,3};
        System.out.println(new Solution().maxProduct(nums));
    }
}