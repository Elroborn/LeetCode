/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-20 09:19:40
 * @FilePath: \leetcode\排序算法\Bubble.java
 * @LastEditTime: 2020-08-20 09:27:14
 */
public class Bubble{
    public void sort(int[] nums){
        for(int i = 0;i<nums.length;i++){ // 轮数
            for(int j = 1;j<nums.length-i;j++){ // 每次大的下沉到最后一个 相邻比较
                //大的下沉
                if(nums[j-1]>nums[j]){
                    int t = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = t;
                }
            }
        }
        
    }
    public static void main(String[] args) {
        int[] nums = {5,5,1,2,3,4};
        new Bubble().sort(nums);
        for(int i:nums){
            System.out.printf("%d ",i);
        }
        
    }
}