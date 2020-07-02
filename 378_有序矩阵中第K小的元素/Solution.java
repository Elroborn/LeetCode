/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-02 10:05:59
 * @FilePath: \leetcode\378_有序矩阵中第K小的元素\Solution.java
 * @LastEditTime: 2020-07-02 10:11:16
 */ 
import java.util.Arrays;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] tmp = new int[matrix.length*matrix[0].length];
        int m = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                tmp[m++] = matrix[i][j];
            }
        }
        Arrays.sort(tmp);
        return tmp[k-1];
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println(new Solution().kthSmallest(matrix, k));
    }
}