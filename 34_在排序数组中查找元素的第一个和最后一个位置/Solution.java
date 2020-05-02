class Solution {
    // https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
    
    public int[] searchRange(int[] nums, int target) {
        int left = left_bound(nums, target);
        int right = right_bound(nums, target);
        return new int[]{left,right};
        
    }
    int left_bound(int[]nums,int target){
        int left = 0,right = nums.length-1,mid=0;
        while(left<=right){
            mid = left +(right-left)/2;
            if(nums[mid]==target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid -1;
            }
        }
        // 如果搜索的数字比所有的都大，最终right位置在最后一个元素，left = right+1
        //             比所有的都小，最终left 在0 。所以如果left>=nums.length || nums[left]!=target则未找到
        if(left>=nums.length || nums[left]!=target){
            return -1;
        }
        return left;
        
    }
    int right_bound(int[] nums,int target){
        int left = 0,right = nums.length-1,mid = 0;
        while(left<=right){
            mid = left +(right-left)/2;
            if(nums[mid]==target){
                left = mid+1;
            }else if(nums[mid]<target){
                left = mid +1;
            }else if(nums[mid]>target){
                right = mid -1;
            }
        }
        if(right<0 || nums[right]!=target){
            return -1;
        }
        return right;
    }
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 0;
        System.out.println(new Solution().searchRange(nums, target)[0]);
    }
}