import java.util.ArrayList;
import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-02 13:57:05
 * @FilePath: \leetcode\46_全排列\Solution2.java
 * @LastEditTime: 2020-08-02 14:29:50
 */ 
class Solution2 {
    private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        int[] vis = new int[nums.length];
        List<Integer> tmp = new ArrayList<>();
        dfs(nums,0,vis,tmp);
        return res;

    }
    private void dfs(int[] nums, int i,int[] vis,List<Integer>  tmp){
        if(i==nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int j=0;j<nums.length;j++){
            if(vis[j]==0){
                vis[j] = 1;
                tmp.add(nums[j]);
                dfs(nums, i+1, vis,tmp);
                tmp.remove(tmp.size()-1);
                vis[j] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        new Solution2().permute(nums);
    }
}