import java.util.HashSet;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-03 14:38:28
 * @FilePath: \leetcode\547_朋友圈\Solution1.java
 * @LastEditTime: 2020-08-03 16:34:53
 */ 
class Solution1 {
    public int findCircleNum(int[][] M) {
        boolean[] vis = new boolean[M.length];
        int res = 0;
        for(int i = 0;i<M.length;i++){
            if(!vis[i]){
                dfs(i,M,vis); // 将所有和i相邻以及和i相邻的 的相邻的对应vis都置为true
                res++;
            }
        }
        return res;
    }
    // 把i相邻的元素，以及i相邻元素的 相邻置为true，是一个递归过程，先找到i的相邻，置为true，然后调用dfs
    private void dfs(int i,int[][] M, boolean[] vis){
        vis[i] = true;
        for(int j = 0;j<M.length;j++){
            if(M[i][j] ==1 && !vis[j]){
                // 说明j和i相邻，所以下一步就是对j以及j的所有邻居染色
                dfs(j, M, vis);
            }
        }
    }

}