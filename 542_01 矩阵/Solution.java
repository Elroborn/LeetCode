import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                res[i][j] = distance(i, j, matrix);
            }
        }
        return res;
    }
    public int distance(int i,int j,int[][] matrix){
        if(matrix[i][j]==0){ //节省开辟队列之类的空间
            return 0; 
        }
        Queue<Integer> queue = new LinkedList<>(); //存储position
        int rows = matrix.length;
        int cols = matrix[0].length;
        queue.add(i*cols + j);
        int dis = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k=0;k<size;k++){
                int pos = queue.poll();
                i = pos/cols;
                j = pos%cols;
                if(matrix[i][j]==0){
                    return dis;
                }
                for(int d=0;d<4;d++){
                    int new_i = i+dirs[d][0];
                    int new_j = j+dirs[d][1];
                    if(new_i>=0 && new_i<matrix.length && new_j>=0 && new_j<matrix[0].length){
                        queue.add(new_i*cols + new_j);
                    }
                }

            }
            dis++;
        }
        return -1;
    }
}