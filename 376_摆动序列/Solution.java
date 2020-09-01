/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-31 14:33:03
 * @FilePath: \leetcode\376_摆动序列\Solution.java
 * @LastEditTime: 2020-08-31 14:37:14
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] up= new int[nums.length];
        int[] down = new int[nums.length];

        for(int i = 1;i<nums.length;i++){
            for(int j= 0;j<i;j++){
                if(nums[j]<nums[i]){
                    up[i] = Math.max(up[i], down[j]+1);
                }
                if(nums[j]>nums[i]){
                    down[i] = Math.max(down[i], up[j]+1);
                }
            }
        }
        return 1+Math.max(up[nums.length-1], down[nums.length - 1]);
    }
}