/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-31 10:03:19
 * @FilePath: \leetcode\841_钥匙和房间\Solution1.java
 * @LastEditTime: 2020-08-31 10:10:58
 */
class Solution1 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        vis[0] = true;
        dfs(rooms,vis,0);
        for(boolean t:vis){
            if(!t){
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms,boolean[] vis,int i){
        List<Integer> list = rooms.get(i);
        for(int key:list){
            if(!vis[key]){
                vis[key] = true;
                dfs(rooms, vis, key);
            }
        }
    }
}