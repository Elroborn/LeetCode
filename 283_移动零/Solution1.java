/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-17 10:27:00
 * @FilePath: \leetcode\283_移动零\Solution1.java
 * @LastEditTime: 2020-11-19 20:12:54
 */
class Solution1 {
    public void moveZeroes(int[] nums) {
        int i = 0,j=0;
        for(;j<nums.length;j++){
            if(nums[j]!=0){
                nums[i++] = nums[j];
            }
        }
        for(;i<nums.length;i++){
            nums[i] = 0;
        }

    }
}