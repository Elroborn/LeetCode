import java.util.HashSet;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-03 14:38:28
 * @FilePath: \leetcode\547_朋友圈\Solution.java
 * @LastEditTime: 2020-08-03 14:56:59
 */ 
class Solution {
    public int findCircleNum(int[][] M) {
        int[] nums = new int[M.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = i;
        }
        for(int i = 0;i<M.length;i++){
            for(int j = 0;j<i;j++){
                int i_father = find(i, nums);
                int j_father = find(j, nums);
                if(M[i][j]==1 && i_father != j_father){
                    //union
                    nums[i_father] = j_father;
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(find(i,nums));
        }
        return set.size();

    }
    public int find(int i, int[] nums){
        while(nums[i]!=i){
            nums[i] = nums[nums[i]];
            i = nums[i];
        }
        return i;
    }
    public static void main(String[] args) {
        int[][] M = {{1,1,0},{1,1,0},{0,0,1}};
        new Solution().findCircleNum(M);
    }
}