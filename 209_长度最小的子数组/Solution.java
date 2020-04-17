class Solution {
    // 暴力也可以考虑先将和存起来比如这道题可以存为 2 5 6 8 12 15 这样任意区间的和就能通过减法得到，减少一个循环
    public int minSubArrayLen1(int s, int[] nums) { //
        if(nums.length==0){
            return 0;
        }
        int sum[] = new int[nums.length];
        sum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i]=sum[i-1] +nums[i];
        }
        for(int w=0;w<nums.length;w++){ 
            for(int i=0;i+w<nums.length;i++){
                int t = sum[i+w] -sum[i] +nums[i];
                if(t>=s){
                    return w+1;
                }
            }
        }
        return 0;
    }

    public int minSubArrayLen(int s, int[] nums) { //滑动窗口
        int left = 0,right = 0; //窗口的左右边界
        int sum = 0;
        int minSize = nums.length+1;
        for(right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=s){
                minSize = Math.min(minSize, right-left+1); //更新
                sum -= nums[left++]; //窗口右移
            }

        }
        return minSize==nums.length+1?0:minSize;
    }
    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};
        System.out.println(new Solution().minSubArrayLen1(7, nums));
        
    }
}