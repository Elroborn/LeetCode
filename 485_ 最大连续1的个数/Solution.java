class Solution {
    public int findMaxConsecutiveOnes1(int[] nums) {
        int k=0,j=0; //k是连续1的第一个1，j是最后一个1
        int res = 0;
        while(j<nums.length){
            k = j;
            while(k<nums.length && nums[k]!=1){
                k++;
            }

            j = k;
            while(j<nums.length && nums[j]==1){
                j++;
            }
            if((j-k)>res){
                res = j-k;
            }
        }
        return res;
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int left = 0,right = 0; //双指针，这样避免那种暴力遍历的每次nums++
        while(right<nums.length){
            if(nums[right]==0){
                res = Math.max(res, right-left);
                right++;
                left = right;
            }else{
                right++;
            }
        }
        return Math.max(res, right-left);
    }
    public static void main(String [] args){
        int[] nums = {1,1,1,0,0,1};
        System.out.println(new Solution().findMaxConsecutiveOnes(nums));
    }
}