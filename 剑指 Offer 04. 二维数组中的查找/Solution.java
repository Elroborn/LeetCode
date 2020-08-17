/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-16 14:26:45
 * @FilePath: \leetcode\剑指 Offer 04. 二维数组中的查找\Solution.java
 * @LastEditTime: 2020-08-16 14:39:38
 */
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        // 先找第几行，再找第几列 
        for(int i =0;i<matrix.length;i++){
            if(matrix[i][0]<target){
                for(int j =0;j<matrix[i].length;j++){
                    if(matrix[i][j]<target){
                        continue;
                    }else if(matrix[i][j]>target){
                        break;
                    }else{ // ===
                        return true;
                    }
                }
            }else if(matrix[i][0]>target){
                break;
            }else{ // ===
                return true;
            }
        }

        return false;
    }
    
}