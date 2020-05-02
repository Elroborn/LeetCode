class Solution1 {
    public int findPeek(int[]nums){
        int left =0,right = nums.length-1,mid = 0;
        while(left<right){
            mid = left +(right-left)/2;
            if(nums[mid]>nums[left]){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int peek = findPeek(nums);
        if(target>=nums[0] && target<=nums[peek]){
            return binarySearch(nums,target,0,peek);
        }else{
            return binarySearch(nums,target,peek+1,nums.length-1);
        }

    }
    public int binarySearch(int[] nums,int target,int left,int right){
        int mid = 0;
        while(left<=right){
            mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(target<nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

}