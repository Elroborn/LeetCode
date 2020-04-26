class Solution {
    public int maxProfit1(int[] prices) {
        int res = 0;
        for(int buy = 0;buy<prices.length;buy++){
            for(int sale = buy+1;sale<prices.length;sale++){
                if(prices[sale]-prices[buy]>res){
                    res = prices[sale]-prices[buy];
                }
            }
        }
        return res;
    }
    public int maxProfit(int[] prices) {
        int res = 0;
        int min_v = prices[0];
        for(int buy = 0;buy<prices.length;buy++){
            res = Math.max(res, prices[buy]-min_v);
            min_v = Math.min(min_v, prices[buy]);
        }
        return res;
    }
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(prices));
    }
}