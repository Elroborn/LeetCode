/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-16 14:40:05
 * @FilePath: \leetcode\剑指 Offer 04. 二维数组中的查找\Solution1.java
 * @LastEditTime: 2020-08-16 14:45:17
 */
class Solution1 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //从右上角开始找 比较好，因为右上角相当于刚好是中间，就是左边的那一行比其小，右边那一列比其大
        // 这样每次都能过滤到一行或者一列
        // 首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束；如果该数字大于要查找的数组，剔除这个数字所在的列；如果该数字小于要查找的数字，剔除这个数字所在的行
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int start_i = 0;
        int start_j = matrix[start_i].length - 1;
        while(start_i< matrix.length && start_j>=0){
            if(matrix[start_i][start_j] == target){
                return true;
            }else if(matrix[start_i][start_j]>target){
                start_j--;
            }else{
                start_i++;
            }
        }
        return false;

    }
}