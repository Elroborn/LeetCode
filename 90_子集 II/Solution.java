import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-17 11:04:23
 * @FilePath: \leetcode\90_子集 II\Solution.java
 * @LastEditTime: 2020-08-17 11:16:01
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        dfs(res,tmp,nums,vis,0);
        return res;
    }
    public void dfs(List<List<Integer>> res,List<Integer> tmp,int[] nums, boolean[] vis,int start){
        res.add(new ArrayList(tmp));
        for(int i = start;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1] && !vis[i-1]){
                continue;
            }else{
                vis[i] = true;
                tmp.add(nums[i]);
                dfs(res, tmp, nums, vis, i+1);
                tmp.remove(tmp.size() - 1);
                vis[i] = false;
            }
        }
    }
}