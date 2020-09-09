import java.util.ArrayList;
import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-09 09:57:29
 * @FilePath: \leetcode\39_组合总和\Solution1.java
 * @LastEditTime: 2020-09-09 10:06:19
 */
class Solution1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(res,tmp,candidates,target,0);
        return res;
    }
    public void dfs(List<List<Integer>> res,List<Integer> tmp,int[] candidates, int target,int start){
        if(target<=0){
            if(target==0){
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        for(int i = start;i<candidates.length;i++){
            tmp.add(candidates[i]);
            dfs(res, tmp, candidates, target-candidates[i],i);;
            tmp.remove(tmp.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        for(List<Integer> r:new Solution1().combinationSum(candidates,8)){
            System.out.println(r.toString());
        }
        
    }
}