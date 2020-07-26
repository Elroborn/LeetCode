/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-22 10:49:38
 * @FilePath: \leetcode\34_在排序数组中查找元素的第一个和最后一个位置\Solution1.java
 * @LastEditTime: 2020-07-22 16:47:11
 */ 
class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int left = left_bound(nums, target);
        int right = right_bound(nums, target);
        return new int[]{left,right};
    }
    public int left_bound(int[] nums ,int target){
        if(nums.length==0){
            return -1;
        }
        int left = 0 ,right = nums.length - 1;
        int mid = 0;
        while(left< right){
            mid = left + (right - left) /2;
            if(nums[mid]>target){
                right = mid - 1;
            }else if(nums[mid]<target){
                left = mid + 1;
            }else{
                right = mid; // 等于的时候说明左边界在[left,mid] 所以right 只能缩小到mid ，而因此外层循环要用<
            }
        }
        // left也是最后的插入位置
        return nums[left]==target? left:-1;
    }
    public int right_bound(int[] nums ,int target){
        if(nums.length==0){
            return -1;
        }
        int left = 0 ,right = nums.length - 1;
        int mid = 0;
        while(left< right){
            mid = left + (right - left + 1) /2; // +1 其实是上取整，避免最后left 和right对应值相等且等于target，这样mid还是等于left，然后判断赋值left = mid ，这样就死循环了
            if(nums[mid]>target){
                right = mid - 1;
            }else if(nums[mid]<target){
                left = mid + 1;
            }else{
                left = mid; // 等于的时候说明左边界在[mid,right] 所以left 只能缩小到mid ，而因此外层循环要用<
            }
        }
        if(left>=nums.length){ // 因为如果找不到 则left对应的位置就是插入的位置，而右查找可能最后插入到末尾则left = num.lengte 下面的num[left]会报错
            return -1;
        }
        return nums[left]==target? left:-1;
    }
    // int right_bound(int[] nums,int target){
    //     int left = 0,right = nums.length-1,mid = 0;
    //     while(left<=right){
    //         mid = left +(right-left)/2;
    //         if(nums[mid]==target){
    //             left = mid+1;
    //         }else if(nums[mid]<target){
    //             left = mid +1;
    //         }else if(nums[mid]>target){
    //             right = mid -1;
    //         }
    //     }
    //     if(right<0 || nums[right]!=target){
    //         return -1;
    //     }
    //     return right;
    // }
    public int binary_search(int[] nums,int target){
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while(left<=right){
            mid = left + (right - left) /2; // 等同于(left+ right) /2 只是可以避免溢出
            if(nums[mid]< target){
                left = mid + 1;
            }else if(nums[mid]>target){
                right = mid - 1;
            }else{ // nums[mid] == target
                return mid;
            }
        }
        return left;// 插入位置
    }
    public static void main(String[] args) {
        int[] nums = {1,3,4};
        System.out.println(new Solution1().binary_search(nums, 2));
    }
}