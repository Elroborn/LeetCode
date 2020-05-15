class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        dfs(rooms, vis, 0);
        for(int i=0;i<vis.length;i++){
            if(vis[i] ==false){
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms,boolean[]vis,int k){
        vis[k] = true;
        for(int i=0;i<rooms.get(k).size();i++){
            if(vis[rooms.get(k).get(i)]==false){
                dfs(rooms, vis, rooms.get(k).get(i));
            }

        }
    }
   
}