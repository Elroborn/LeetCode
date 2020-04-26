import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>tmp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums,used,tmp,res,0);
        return res;

    }
    public void dfs(int[]nums,boolean[] used,List<Integer>tmp,List<List<Integer>> res,int depth){
        if(depth == nums.length){
            res.add(new ArrayList<>(tmp)); //因为tmp只是引用，所以拷贝一份
            return;
        }
        for(int i =0;i<nums.length;i++){ //每个结点的所有可能
            if(!used[i]){
                tmp.add(nums[i]); //添加到了末尾
                used[i] = true;
                dfs(nums, used, tmp, res, depth+1);
                used[i] = false;
                tmp.remove(tmp.size()-1);//因为之前是添加到末尾的 移除最后一个
            }
        }

    }

    public static void main(String[] args) {
        int nums[] ={1,2,3};
        List<List<Integer>> res = new Solution1().permute(nums);
        System.out.println(res);

    }
}