class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        boolean[][] vis = new boolean[image.length][image[0].length];
        dfs(image, vis, sr, sc, newColor, originColor);
        return image;

    }
    public void dfs(int[][]image,boolean[][]vis,int i,int j,int newColor,int originColor){
        if(i>=image.length || i<0 || j>=image[0].length || j<0){
            return;
        }
        if(originColor!=image[i][j]){
            return;
        }
        if(vis[i][j]){
            return;
        }
        vis[i][j] = true;
        image[i][j] = newColor;
        dfs(image, vis, i+1, j, newColor, originColor);
        dfs(image, vis, i-1, j, newColor, originColor);
        dfs(image, vis, i, j+1, newColor, originColor);
        dfs(image, vis, i, j-1, newColor, originColor);
    }
    // public static void main(String[] args) {
        
    // }
}