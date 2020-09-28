/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-28 08:51:42
 * @FilePath: \leetcode\剑指 Offer 15. 二进制中1的个数\Solution.java
 * @LastEditTime: 2020-09-28 09:17:45
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while(n!=0){
            if((n&1)!=0){
                cnt++;
            }
            n>>>=1; //Java中无符号右移用>>>
        }
        return cnt;
        
    }
}