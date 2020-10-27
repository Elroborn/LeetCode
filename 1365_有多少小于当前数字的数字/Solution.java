/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-27 08:41:28
 * @FilePath: \leetcode\1365_有多少小于当前数字的数字\Solution.java
 * @LastEditTime: 2020-10-27 08:44:40
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        int[] cnt = new int[101];
        for(int i = 0;i<nums.length;i++){
            cnt[nums[i]]++;
        }
        for(int i= 1;i<cnt.length;i++){
            cnt[i] = cnt[i] +cnt[i-1];
        }
        for(int i = 0;i<res.length;i++){
            res[i] = nums[i]==0?0:cnt[nums[i]-1];
        }
        return res;

    }
}