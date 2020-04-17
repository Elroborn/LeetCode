class Solution {
    public int maxSubArray(int[] nums) {
        int sum[] = new int[nums.length];
        sum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i] = sum[i-1] +nums[i];
        }
        int max_v = Integer.MIN_VALUE;
        for(int w = 0;w<nums.length;w++){
            for(int i=0;i+w<nums.length;i++){
                int t = sum[i+w] - sum[i] + nums[i];
                if(t>max_v){
                    max_v = t;
                }
            }
        }
        return max_v;
    }
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(nums));
    }
}