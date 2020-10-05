import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-05 09:02:36
 * @FilePath: \leetcode\18_四数之和\Solution.java
 * @LastEditTime: 2020-10-05 10:07:05
 */
//超时
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         Arrays.sort(nums);
//         HashSet<String> set = new HashSet<>();
//         List<List<Integer>> res = new ArrayList<>();
//         List<Integer> tmp = new ArrayList<>();
//         dfs(set,nums,res,tmp,target,0,0);
//         return res;
//     }

//     private void dfs(HashSet<String> set,int[] nums, List<List<Integer>> res, List<Integer> tmp, int target, int start, int sum) {
//         if(tmp.size()==4 && sum==target && !set.contains(tmp.toString())){
//             set.add(tmp.toString());
//             res.add(new ArrayList<>(tmp));
//             return;
//         }
//         if(tmp.size()>4){
//             return;
//         }
//         for(int i = start;i<nums.length;i++){
//             tmp.add(nums[i]);
//             dfs(set,nums, res, tmp, target, i+1, sum+nums[i]);
//             tmp.remove(tmp.size()-1);
//         }

//     }
//     public static void main(String[] args) {
//         int[] nums = {-5,5,4,-3,0,0,4,-2};
//         List<List<Integer>> res = new Solution().fourSum(nums, 4);
//         for(List<Integer> t :res){
//             System.out.println(t.toString());
//         }

        
//     }
// }

//利用三数之和思想 多一层for
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j = i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int left = j+1;
                int right = nums.length -1;
                while(left<right){
                    int sum = nums[left] + nums[right] + nums[j];
                    if(sum ==target -nums[i]){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left+1] == nums[left]){ // 找到一个left+1是不等于left的
                            left++;
                        } 
                        while(left<right && nums[right-1] ==nums[right]){
                            right--;
                        }
                        left++; //因为是left+1!=left 所以需要将left置为left+1
                        right--;
                    }else if(sum>target - nums[i]){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,1,2,2};
        List<List<Integer>> res = new Solution().fourSum(nums, 0);
        for(List<Integer> t :res){
            System.out.println(t.toString());
        }

        
    }
}