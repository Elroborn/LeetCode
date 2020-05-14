class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target = image[sr][sc];
        int[][] visited = new int[image.length][image[0].length];
        dfs(image, sr, sc, visited, target, newColor);
        return image;
    }
    public void dfs(int[][] image,int x,int y,int[][] visited, int target,int newColor){
        for(int i=0;i<4;i++){
            image[x][y] = newColor;
            visited[x][y] = 1;
            int new_x = x + dirs[i][0];
            int new_y = y + dirs[i][1];
            if(new_x>=0 && new_x<image.length && new_y>=0 && new_y<image[new_x].length &&image[new_x][new_y]==target && visited[new_x][new_y]==0){
                dfs(image, new_x, new_y, visited, target, newColor);
            }
        }
    }
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        image = new Solution().floodFill(image, 1, 1, 2);
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.println(image[i][j]);
            }
        }
    }
}