import java.util.ArrayList;
import java.util.List;
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-12 10:13:04
 * @FilePath: \leetcode\77_组合\Solution.java
 * @LastEditTime: 2020-08-12 10:24:20
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] vis = new boolean[n+1];
        dfs(n,k,res,tmp,vis);
        return res;
    }
    public void dfs(int n,int k,List<List<Integer>> res,List<Integer> tmp,boolean[] vis){
        if(tmp.size() == k){
            res.add(new ArrayList(tmp));
            return;
        }
        for(int i = 1;i<=n;i++){
            if(!vis[i] && i> (tmp.size()>=1?tmp.get(tmp.size()-1):-1)){
                vis[i] = true;
                tmp.add(i);
                dfs(n, k, res, tmp, vis);
                tmp.remove(tmp.size()-1);
                vis[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> res  = new Solution().combine(4, 2);
        for(List<Integer> t:res){
            for(int i:t){
                System.out.printf("%d ",i);
            }
            System.out.println();
        }
    }
}