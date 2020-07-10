/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-10 11:03:30
 * @FilePath: \leetcode\122_买卖股票的最佳时机 II\Solution.java
 * @LastEditTime: 2020-07-10 11:17:03
 */ 
class Solution {
    public int maxProfit(int[] prices) {
        //在跌的最厉害的时候买，在涨的最厉害的时候卖
        int min_v = prices[0];
        int max_v = prices[0];
        int i = 0;
        int res = 0;
        while(i<prices.length-1){
            while(i<prices.length - 1 && prices[i+1]<=prices[i]){
                i++;
            }
            min_v = prices[i];
            while(i<prices.length -1 && prices[i+1]>=prices[i]){
                i++;
            }
            max_v = prices[i];
            res += (max_v - min_v);
        }
        return res;
        
    }
}