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
        int row = matrix.length;
        int col = matrix[0].length;
        boolean vis[][] = new boolean[row][col];
        int dir[][] ={{0,1},{1,0},{0,-1},{-1,0}};
        int r=0,c=0,d=0;
        for(int i=0;i<row*col;i++){
            res.add(matrix[r][c]);
            vis[r][c] = true;
            int nr = r+ dir[d][0];
            int nc = c+ dir[d][1];
            if(nr<row && nr>=0 && nc<col && nc>=0 && vis[nr][nc]==false){
                r = nr;
                c = nc;
            }else{
                //调整方向
                d = (d+1)%4;
                r = r+ dir[d][0];
                c = c+ dir[d][1];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int [][]matrix = {{1,2,2},{3,4,2}};
        System.out.println(new Solution().spiralOrder(matrix));
    }
}