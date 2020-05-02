class Solution {
    public int findMin(int[] nums) {
        int left = 0,right = nums.length-1;
        int mid = 0;
        while(left<right){
            mid = left +(right-left)/2;
            if(nums[mid]<nums[right]){ //左边有序
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return nums[left];
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(new Solution().findMin(nums));
    }
}