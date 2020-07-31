/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-31 10:28:36
 * @FilePath: \leetcode\面试题 08.03. 魔术索引\Solution.java
 * @LastEditTime: 2020-07-31 10:29:56
 */ 
class Solution {
    public int findMagicIndex(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == i){
                return i;
            }
        }
        
        return -1;

    }
}