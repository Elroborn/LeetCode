/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-08 09:19:18
 * @FilePath: \leetcode\78_子集\Solution1.java
 * @LastEditTime: 2020-09-20 10:38:41
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<(1 << nums.length);i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0;j<nums.length;j++){
                if(((i>>j)&1)==1){
                    tmp.add(nums[j]);
                }
            }
            res.add(tmp);
        }
        return res;

    }
}