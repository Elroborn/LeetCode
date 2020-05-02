class Solution {
    public int search1(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        int mid = 0;
        while(left<=right){
            mid = (left+right)/2;
            if(target == nums[mid]){
                return mid;
            }else if(target>nums[mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        int mid = 0;
        while(left<right){ //注意是<
            mid = left +(right -left) /2; //这样可避免加法溢出
            if(nums[mid]<target){
                left = mid+1;
            }else{//<=情况，所以不能mid-1
                right = mid; 
            }
        }
        //跳出则肯定left == right 判断是否等于target
        if(nums[left]==target){ //如果查找后插入，则返回left即可，便是插入位置
            return left;
        }else{
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] nums = {3,5,7,10,12};
        new Solution().search(nums, 6);
    }
}