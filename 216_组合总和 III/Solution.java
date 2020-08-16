import java.util.ArrayList;
import java.util.List;
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-14 10:47:01
 * @FilePath: \leetcode\216_组合总和 III\Solution.java
 * @LastEditTime: 2020-08-14 10:55:10
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // k个数 和为n （1-9）
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] vis = new boolean[10];// vis 可以不要， 因为i是从start 用过的自然不会再被浏览到
        if(k==0 || n==0){
            return res;
        }
        dfs(res, tmp, vis, 1, k, n);
        return res;

    }
    public void dfs(List<List<Integer>> res,List<Integer> tmp,boolean[] vis,int start,int k,int n){
        if(tmp.size()>k){
            return;
        }
        if(tmp.size() == k && n ==0){
            res.add(new ArrayList<>(tmp));
            return ;
        }
        for(int i = start;i<=9;i++){
            if(i<=n && !vis[i]){
                vis[i] = true;
                tmp.add(i);
                dfs(res, tmp, vis, i+1, k, n-i);
                tmp.remove(tmp.size() -1);
                vis[i] = false;
            }
        }
    }
}