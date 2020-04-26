import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>tmp = new ArrayList<>();
        for(int n:nums){
            tmp.add(n);
        }
        helper(tmp, 0, res);
        return res;
    }
    public void helper(List<Integer>nums,int k,List<List<Integer>> res){
        if(k==nums.size()){
            res.add(new ArrayList<Integer>(nums));
            return;
        }
        for(int i=k;i<nums.size();i++){
            swap(nums, i, k);
            helper(nums, k+1, res);
            swap(nums, i, k);

        }
    
    }
    public void swap(List<Integer>nums,int a,int b){
        int t = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, t);
    }
    public static void main(String[] args) {
        int nums[] ={1,2,3};
        List<List<Integer>> res = new Solution().permute(nums);
        System.out.println(res);

    }
}