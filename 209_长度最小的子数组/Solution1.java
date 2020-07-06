/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-04-21 12:27:34
 * @FilePath: \leetcode\209_长度最小的子数组\Solution1.java
 * @LastEditTime: 2020-07-06 10:46:59
 */ 
class Solution1 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] preFix = new int[nums.length+1];
        preFix[0] = 0;
        for(int i=1;i<=nums.length;i++){
            preFix[i] = nums[i-1] + preFix[i-1];
        }
        // sum[i,j] = preFix[j+1] - preFix[i] e.g. sum[0,0] = preFix[1] - preFix[0]
        for(int w = 0;w<nums.length;w++){
            for(int i=0;i+w<nums.length;i++){
                int t = preFix[i+w+1] - preFix[i];
                if(t>=s){
                    return w+1;
                }
            }
        }
        return 0;

    }
}