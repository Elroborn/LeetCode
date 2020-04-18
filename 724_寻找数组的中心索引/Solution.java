class Solution {
    public int pivotIndex(int[] nums) {
        // leftSum = sum - leftSum -nums[i] 
        int sum = 0;
        for(int n :nums){
            sum+=n;
        }
        int leftSum = 0;
        for(int i=0;i<nums.length;i++){ // i是分割点
            if(sum-leftSum-nums[i]==leftSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int nums[] = {1,7,3,6,5,6};
        System.out.println(new Solution().pivotIndex(nums));
    }
}