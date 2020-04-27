class Solution {
    public int search(int[] nums, int target) {
        return mid_search(nums, 0, nums.length-1, target);

    }
    int mid_search(int[]nums,int low,int high,int target){
        if(low>high){
            return -1;
        }
        int mid = (low+high) /2;
        if(nums[mid]==target){
            return mid;
        }
        int l1 = mid_search(nums, low, mid-1, target);
        if(l1!=-1){
            return l1;
        }
        int l2 = mid_search(nums, mid+1, high, target);
        if(l2!=-1){
            return l2;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(new Solution().search(nums, 4));
    }
}