import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-05 09:32:49
 * @FilePath: \leetcode\15_三数之和\Solution.java
 * @LastEditTime: 2020-10-05 09:59:22
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<nums.length -2;i++){
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            } 
            int left = i+1;
            int right = nums.length -1;
            while(left<right){ // 双指针
                 if(nums[left]+nums[right]==-nums[i]){
                     res.add(Arrays.asList(nums[i],nums[left],nums[right]));

                     while(left<right && nums[left]==nums[left+1]){
                         left++;
                     }
                     while(left<right && nums[right-1] == nums[right]){
                         right--;
                     }
                     left++;
                     right--;
                 }else if(nums[left]+nums[right]>-nums[i]){
                     right--;
                 }else{
                     left++;
                 }
            }
        }
        return res;

    }
}