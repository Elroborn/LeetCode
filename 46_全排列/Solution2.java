import java.util.ArrayList;
import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-02 13:57:05
 * @FilePath: \leetcode\46_全排列\Solution2.java
 * @LastEditTime: 2020-09-17 21:45:22
 */
class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        backTrack(nums,res,tmp,vis);
        return res;
    }

    public void backTrack(int[] nums,List<List<Integer>> res,List<Integer> tmp,boolean[] vis){
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                tmp.add(nums[i]);
                vis[i] = true;
                backTrack(nums, res, tmp, vis);
                vis[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }

    }
}