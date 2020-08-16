import java.util.List;
import java.util.ArrayList;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-13 11:00:07
 * @FilePath: \leetcode\78_子集\Solution.java
 * @LastEditTime: 2020-08-13 11:11:11
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if(nums.length ==0){
            return res;
        }
        dfs(nums,tmp,res,0);
        return res;
    }
    public void dfs(int[] nums,List<Integer> tmp,List<List<Integer>> res,int start){
        res.add(new ArrayList<>(tmp));
        for(int i = start;i<nums.length;i++){
            tmp.add(nums[i]);
            dfs(nums, tmp, res, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = new Solution().subsets(nums);
        for(List<Integer> t:res){
            for(int i:t){
                System.out.printf("%d ",i);
            }
            System.out.println();
        }
    }
}