/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-19 11:03:49
 * @FilePath: \leetcode\排序算法\QuickSort.java
 * @LastEditTime: 2020-08-19 11:11:47
 */
public class QuickSort{
    public void quick_sort(int[] nums,int i,int j){
        if(i>=j){
            return ;
        }
        int k = partion(nums,i,j);
        quick_sort(nums, i, k-1);
        quick_sort(nums, k+1, j);
    }
    public int partion(int[] nums,int i,int j){
        int t = nums[i];
        while(i<j){
            // 一定注意是>=t 因为对于 4 4 4 1 2 3 4 4 如果是> 则会死循环
            while(i<j && nums[j]>=t){
                j--;
            }
            nums[i] = nums[j];
            while(i<j && nums[i]<=t){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = t;
        return i;
    }
    public static void main(String[] args) {
        int[] nums = {4,4,1,2,3,4,4};
        new QuickSort().quick_sort(nums, 0, nums.length - 1);
        for(int i: nums){
            System.out.printf("%d ",i);
        }
    }
}
