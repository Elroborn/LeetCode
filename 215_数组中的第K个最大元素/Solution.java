/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-05-24 10:23:24
 * @FilePath: \leetcode\215_数组中的第K个最大元素\Solution.java
 * @LastEditTime: 2020-07-06 11:09:04
 */ 
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quick_sort(nums, 0, nums.length - 1, k);
    }
    // 这次要直接将其按照从大到小排序
    public int quick_sort(int[] nums,int left,int right,int k){
        if(left>=right){
            return nums[left];
        }
        int i = left, j = right, t = nums[left];
        // 正常快排是从小到大，则让右边都比t大等，此时要求是从大到小，则右边需要比t都小等
        while(i<j){
            while(i<j && nums[j]<=t){
                j--;
            }
            nums[i] = nums[j];
            while(i<j && nums[i]>=t){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = t;
        if(i>k-1){ // 比如要前2 则对应位置是1因为数组下标从0开始
            return quick_sort(nums, left, i-1, k);
        }else if(i<k-1){
            return quick_sort(nums, i+1, right, k);
        }else{
            return nums[i];
        }
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(new Solution().findKthLargest(nums, k));
        for(int i:nums){
            System.out.println(i);
        }
    }
}