/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-04-19 12:51:20
 * @FilePath: \leetcode\54_螺旋矩阵\Solution.java
 * @LastEditTime: 2020-09-05 11:26:44
 */
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length==0){
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean vis[][] = new boolean[row][col];
        int circles = (Math.min(row,col)+1)/2;
        int r = 0,c=0; 
        for(int d = 0;d<circles;d++){
            while(c<col && !vis[r][c]){ //右
                vis[r][c] = true;
                res.add(matrix[r][c]);
                c++;
            }
            c-=1;
            r+=1;
            while(r<row && !vis[r][c]){//下
                vis[r][c] = true;
                res.add(matrix[r][c]);
                r++;
            }
            r-=1;
            c-=1;
            while(c>=0 && !vis[r][c]){//左
                vis[r][c] = true;
                res.add(matrix[r][c]);
                c--;
            }
            c += 1;
            r-=1;
            while(r>=0 && !vis[r][c]){//上
                vis[r][c] = true;
                res.add(matrix[r][c]);
                r--;
            }
            r+=1;
            c+=1;
        }
        return res;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length==0){
            return res;
        }
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int dIndex = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int nums = rows*cols;
        boolean[][] vis = new boolean[rows][cols];
        int i = 0,j = 0;
        for(int k = 0;k<nums;k++){
            res.add(matrix[i][j]);
            vis[i][j] = true;
            int new_i = i + dirs[dIndex][0],new_j = j + dirs[dIndex][1];
            if(new_i<0 || new_i>=rows || new_j<0 || new_j>=cols || vis[new_i][new_j]){
                dIndex = (dIndex+1)%4;
            }
            i+=dirs[dIndex][0];
            j+=dirs[dIndex][1];
        }
        return res;
    }
    public static void main(String[] args) {
        int [][]matrix = {{1,2,2},{3,4,2}};
        System.out.println(new Solution().spiralOrder(matrix));
    }
}