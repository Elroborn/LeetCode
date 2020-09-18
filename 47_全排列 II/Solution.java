/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-18 13:50:34
 * @FilePath: \leetcode\47_全排列 II\Solution.java
 * @LastEditTime: 2020-09-18 13:54:17
 */
import java.util.*;
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>(), new boolean[nums.length], new HashSet<>());
        return res;

    }
    public void dfs(int[] nums,List<List<Integer>> res,List<Integer> tmp,boolean[] vis,HashSet<String> set){
        if(tmp.size()==nums.length){
            if(!set.contains(tmp.toString())){
                res.add(new ArrayList<>(tmp));
                set.add(tmp.toString());
            }
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(!vis[i]){
                vis[i] = true;
                tmp.add(nums[i]);
                dfs(nums, res, tmp, vis,set);
                tmp.remove(tmp.size()-1);
                vis[i] = false;
            }
        }
    }
}