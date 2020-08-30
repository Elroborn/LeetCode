/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-25 11:00:16
 * @FilePath: \leetcode\91_解码方法\Solution.java
 * @LastEditTime: 2020-08-25 11:23:58
 */

// https://leetcode-cn.com/problems/decode-ways/solution/c-wo-ren-wei-hen-jian-dan-zhi-guan-de-jie-fa-by-pr/
class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1; // i = 0;
        int j = 0;
        for(int i = 1;i<s.length();i++){
            j = i+1;
            if(s.charAt(i)==0){
                if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2'){
                    dp[j] = dp[j-2];
                }else{
                    return 0;
                }
            }
            if(s.charAt(i-1)=='1'){
                dp[j] = dp[j-1] + dp[j-2]; // s[i-1] 与s[i]分开译码为dp[j-1] 合并为dp[j-2]
            }
            if(s.charAt(i-1)=='2'){
                if(s.charAt(i)>='0' && s.charAt(i)<='6'){
                    dp[j] = dp[i-1] + dp
                }
                
            }
        }
    }


}