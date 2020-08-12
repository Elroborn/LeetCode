import java.util.ArrayList;
import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-12 10:45:23
 * @FilePath: \leetcode\39_组合总和\Solution.java
 * @LastEditTime: 2020-08-12 10:53:54
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(candidates,0,target,res,tmp);
        return res;
    }
    public void dfs(int[] candidates,int start,int left,List<List<Integer>> res,List<Integer> tmp){
        if(left ==0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = start;i<candidates.length;i++){
            if(candidates[i]<=left){
                tmp.add(candidates[i]);
                dfs(candidates,i, left - candidates[i], res, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int[]candidates = {2,3,6,7};
        List<List<Integer>> res = new Solution().combinationSum(candidates, 7);
        for(List<Integer> l:res){
            for(int i:l){
                System.out.printf("%d ",i);
            }
            System.out.println();
        }
    }
}