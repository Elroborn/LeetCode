/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-01 11:07:04
 * @FilePath: \leetcode\剑指 Offer 56 - I. 数组中数字出现的次数\Solution.java
 * @LastEditTime: 2020-09-01 12:28:02
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for(int n:nums){
            res^=n;
        }
        int dev = 1;
        while((dev&res)==0){
            dev<<=1;
        }
        int[] ans = new int[2];
        for(int n:nums){
            if((dev&n)==0){
                ans[0]^=n;
            }else{
                ans[1]^=n;
            }
        }
        return ans;
    }
}