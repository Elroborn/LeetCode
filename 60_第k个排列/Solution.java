/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-05 09:53:55
 * @FilePath: \leetcode\60_第k个排列\Solution.java
 * @LastEditTime: 2020-09-05 10:47:38
 */
// 未通过，但是本地测的那个数据是没问题的 4 9
class Solution {
    private static int i = 0;
    private static String res = "";
    public String getPermutation(int n, int k) {
        boolean[] vis = new boolean[n+1];
        dfs(vis,n,k,"");
        return res;
    }
    public void dfs(boolean[] vis,int n,int k,String s){
        if(s.length()==n){
            // System.out.println(s);
            i++;
            if(i==k){
                res = s;
            }
            return;
        }
        for(int j = 1;j<=n;j++){
            if(!vis[j] && i<k){
                vis[j] = true;
                dfs(vis, n, k, s+j);
                vis[j] = false;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(4, 9));
    }
}