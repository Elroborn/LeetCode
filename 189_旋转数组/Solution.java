class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public void reverse(int[] nums,int left,int right){
        while(left<right){
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        int nums[] = {-1};
        new Solution().rotate(nums, 1);;
        for(int i :nums){
            System.out.println(i);
        }
        
    }
}