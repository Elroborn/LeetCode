class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0,right = nums.length-1;
        int mid = 0;
        while(left<right){
            mid = left + (right-left)/2;
            if(nums[mid]<nums[mid+1]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(new Solution().findPeakElement(nums));
    }
}