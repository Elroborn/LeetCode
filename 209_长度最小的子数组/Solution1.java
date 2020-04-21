class Solution1 {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0,right = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while(right<nums.length){
            while(sum<s && right<nums.length){
                sum+=nums[right];
                right++;//扩大窗口
            }
            while(sum>=s && left<nums.length){
                res = Math.min(res, right-left);
                sum-=nums[left];
                left++; //缩小窗口
            }
        }

        return res==Integer.MAX_VALUE?0:res;
        
    }
    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};
        System.out.println(new Solution1().minSubArrayLen(7, nums));
        
    }
}