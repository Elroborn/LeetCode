/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-20 11:02:21
 * @FilePath: \leetcode\785_判断二分图\Solution.java
 * @LastEditTime: 2020-09-20 11:13:46
 */
class Solution {
    boolean isValid = true;
    public boolean isBipartite(int[][] graph) {
        int node = graph.length;
        for(int i=0;i<node;i++){
            int[] vis = new int[node];
            vis[i] = 1;
            dfs(graph, vis, i);

        }
        return isValid;
    }

    private void dfs(int[][] graph, int[] vis, int i) {
        for(int neig:graph[i]){
            if(vis[neig]==0){
                vis[neig] = -vis[i];
                dfs(graph, vis, neig);
                if(!isValid){
                    return;
                }
            }else{
                if(vis[neig] == vis[i]){
                    isValid = false;
                }
            }
        }
    }
}