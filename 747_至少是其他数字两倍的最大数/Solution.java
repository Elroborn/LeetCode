class Solution {
    public int dominantIndex(int[] nums) {
        //下面因为有乘法可能效率低，或者采用第一次找最大，第二次找次大，这样只需要一次乘法
        int t = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[t]){
                t = i;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i!=t && nums[i]*2>nums[t]){
                return -1;
            }
        }
        return t;
    }
    public static void main(String[] args) {
        int nums[] = {3, 6, 1, 0};
        System.out.println(new Solution().dominantIndex(nums));
    }
}
