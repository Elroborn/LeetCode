// https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/java-dong-tai-gui-hua-si-lu-bu-zou-cong-hou-xiang-/
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int max_day = days[days.length-1],min_day = days[0];
        int[] dp = new int[max_day + 31];
        int cur = days.length-1;
        int t1;
        for(int d = max_day;d>=min_day;d--){
            if(d==days[cur]){ //从后向前
                t1 = Math.min(dp[d+1]+costs[0],dp[d+7]+costs[1]);
                dp[d] = Math.min(t1, dp[d+30]+costs[2]);
                cur--;
            }else{
                dp[d] = dp[d+1];
            }
        }
        return dp[min_day];
    }
    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20}, costs = {2,7,15};
        System.out.println(new Solution().mincostTickets(days, costs));
    }
}