/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-19 12:12:13
 * @FilePath: \leetcode\剑指 Offer 39. 数组中出现次数超过一半的数字\Solution.java
 * @LastEditTime: 2020-08-19 12:13:13
 */
class Solution {
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int cnt = 1;
        for(int i =1;i<nums.length;i++){
            if(nums[i] == element){
                cnt++;
            }else{
                cnt--;
                if(cnt==0){
                    cnt = 1;
                    element = nums[i];
                }
            }
        }
        return element;
    }
}