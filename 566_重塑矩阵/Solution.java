/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-17 10:32:23
 * @FilePath: \leetcode\566_重塑矩阵\Solution.java
 * @LastEditTime: 2020-09-17 10:44:26
 */
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int index_i = 0;
        int index_j = 0;
        if(r*c> nums.length * nums[0].length){
            return nums;
        }
        int[][] res = new int[r][c];
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<nums[0].length;j++){
                res[index_i][index_j] = nums[i][j];
                index_j = (index_j+1)%c;
                if(index_j==0){
                    index_i = (index_i+1)%r;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4}};
        int[][] res = new Solution().matrixReshape(nums, 2, 2);
        for(int[] ns:res){
            for(int n:ns){
                System.out.printf("%d",n);
            }
            System.out.println();
        }
    }
}