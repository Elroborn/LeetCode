/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-16 14:12:19
 * @FilePath: \leetcode\733_图像渲染\Solution1.java
 * @LastEditTime: 2020-08-16 14:20:47
 */
class Solution1 {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length ==0 | image[0].length ==0){
            return image;
        }
        int oldColor = image[sr][sc];
        if(newColor == oldColor){
            return image;
        }
        dfs(image,sr,sc,oldColor,newColor);
        return image;

    }
    public void dfs(int[][] image,int sr,int sc,int oldColor,int newColor){
        image[sr][sc] = newColor;
        for(int[] dir:dirs){
            int new_sr = sr + dir[0];
            int new_sc = sc + dir[1];
            if(new_sr>=0 && new_sr<image.length && new_sc >=0 && new_sc<image[new_sr].length && image[new_sr][new_sc]==oldColor){
                dfs(image, new_sr, new_sc, oldColor, newColor);
            }
        }
        
    }
}