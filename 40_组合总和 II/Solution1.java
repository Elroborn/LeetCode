import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-10 10:45:32
 * @FilePath: \leetcode\40_组合总和 II\Solution1.java
 * @LastEditTime: 2020-09-10 11:23:16
 */
// [1,1] 1 本地测可以，但是线上无法通过，不知道原因
class Solution1 {
    private static HashSet<String> set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res,tmp,candidates,target,0);
        return res;
    }
    public void dfs(List<List<Integer>> res,List<Integer> tmp,int[] candidates, int target,int start){
        if(target<=0){
            if(target==0){
                if(!set.contains(tmp.toString())){
                    res.add(new ArrayList<>(tmp));
                    set.add(tmp.toString());
                }
            }
            return;
        }
        for(int i = start;i<candidates.length;i++){
            // if(tmp.size()>0 && tmp.get(tmp.size()-1)==candidates[i]){
            //     continue;
            // }
            tmp.add(candidates[i]);
            dfs(res, tmp, candidates, target-candidates[i], i+1);
            tmp.remove(tmp.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] candidates = {1,1};
        for(List<Integer> r:new Solution1().combinationSum2(candidates,1)){
            System.out.println(r.toString());
        }
    }

}