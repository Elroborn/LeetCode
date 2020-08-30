import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-25 10:25:50
 * @FilePath: \leetcode\491_递增子序列\Solution.java
 * @LastEditTime: 2020-08-25 10:54:57
 */
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        dfs(res,tmp,set,nums,0);
        return res;
    }
    public void dfs(List<List<Integer>> res,List<Integer> tmp,HashSet<String> set,int[] nums,int start){
        if(tmp.size()>=2){
            if(!set.contains(tmp.toString())){
                res.add(new ArrayList<>(tmp));
                set.add(tmp.toString());
            }
        }
        for(int i = start;i<nums.length;i++){
            if(tmp.size()==0 || (tmp.size()>0 && nums[i]>=tmp.get(tmp.size()-1))){
                tmp.add(nums[i]);
                dfs(res, tmp,set,nums, i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        List<List<Integer>> res = new Solution().findSubsequences(nums);
        for(List<Integer> t:res){
            System.out.println(t.toString());
        }
    }
}