class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        return quice_sort(nums, 0, nums.length-1, k);
    }
    public int quice_sort(int[]nums,int left,int right,int k){
        if(left>=right){
            return nums[left];
        }
        int tmp = nums[left];
        int i = left,j = right;
        while(i<j){
            while(i<j && nums[j]>=tmp){
                j--;
            }
            nums[i] = nums[j];
            while(i<j && nums[i]<=tmp){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = tmp;
        if(nums.length - i==k){
            return nums[i];
        }else if(k>nums.length - i){
            return quice_sort(nums, left, i-1, k);
        }else{
            return quice_sort(nums, i+1, right, k);
        }
    }
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(new Solution().findKthLargest(nums, k));

    }
}