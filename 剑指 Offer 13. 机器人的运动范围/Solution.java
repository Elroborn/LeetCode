/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-10 11:16:59
 * @FilePath: \leetcode\剑指 Offer 13. 机器人的运动范围\Solution.java
 * @LastEditTime: 2020-10-10 15:59:12
 */
class Solution {
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private int cnt = 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] vis = new boolean[m][n];
        dfs(m,n,k,0,0,vis);
        return cnt;
    }

    private void dfs(int m, int n, int k,int i,int j, boolean[][] vis) {
        if(check(i,j,k)){
            cnt++;
        }
        for(int[] dir:dirs){
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(new_i>=0 && new_i<m && new_j>=0 && new_j<n && !vis[new_i][new_j]){
                vis[new_i][new_j] = true;
                dfs(m, n, k, new_i, new_j, vis);
            }
        }
    }

    private boolean check(int i, int j,int k) {
        int s = 0;
        while(i!=0){
            s+=(i%10);
            i/=10;
        }
        while(j!=0){
            s+=(j%10);
            j/=10;
        }
        return s<=k;
    }
    public static void main(String[] args) {
        new Solution().movingCount(1, 2, 1);
    } 
}