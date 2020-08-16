import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-14 10:31:39
 * @FilePath: \leetcode\40_组合总和 II\Solution.java
 * @LastEditTime: 2020-08-14 10:39:44
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] vis = new boolean[candidates.length];
        if(candidates.length ==0){
            return res;
        }
        Arrays.sort(candidates); // 重要
        dfs(res, tmp, vis, 0, target, candidates);
        return res;
    }
    public void dfs(List<List<Integer>> res,List<Integer> tmp,boolean[] vis,int start,int target,int[] candidates){
        if(target ==0){
            res.add(new ArrayList(tmp));
            return;
        }
        for(int i = start;i<candidates.length;i++){
            if(i>0 && candidates[i] == candidates[i-1] && !vis[i-1]){ // 如果i-1还没有做，先做了i 这样就会重复
                continue;
            }
            if(candidates[i]<=target){
                vis[i] = true;
                tmp.add(candidates[i]);
                dfs(res, tmp, vis, i+1, target-candidates[i], candidates);
                tmp.remove(tmp.size() -1);
                vis[i] = false;
            }
        }
    }
}