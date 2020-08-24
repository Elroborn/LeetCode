/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-24 14:14:40
 * @FilePath: \leetcode\排序算法\MergeSort.java
 * @LastEditTime: 2020-08-24 14:23:46
 */
class MergeSort{
    public static void merge_sort(int[] nums,int i,int j){
        if(i>=j){
            return ;
        }
        int mid = i + (j-i)/2;
        merge_sort(nums, i, mid);
        merge_sort(nums, mid+1, j);
        merge(nums,i,mid,j);
    }
    public static void merge(int[] nums,int left,int mid,int right){
        int[] tmp = new int[right - left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                tmp[k++] = nums[i++];
            }else{
                tmp[k++] = nums[j++];
            }
        }
        while(i<=mid){
            tmp[k++] = nums[i++];
        }
        while(j<=right){
            tmp[k++] = nums[j++];
        }
        k = 0;
        for(i = left;i<=right;i++){
            nums[i] = tmp[k++];
        }
        
    }
    public static void main(String[] args) {
        int[] nums = {1,1};
        merge_sort(nums, 0, nums.length-1);
        for(int i:nums){
            System.out.printf("%d ",i);
        }
    }
}