class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length,cols = matrix[0].length;
        int maxEdg = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='1'){
                    maxEdg = Math.max(maxEdg,1);
                    int t = Math.min(rows-i,cols-j);
                    for(int k=1;k<t;k++){ //新增一圈
                        boolean flage = true;
                        if(matrix[i+k][j+k]=='0'){ // 先看对角，如果不可，则此圈加不进去 结束
                            break;
                        }
                        for(int m=0;m<k;m++){
                            if(matrix[i+k][j+m]=='0' || matrix[i+m][j+k]=='0'){// 新增的一圈的两个边做判断
                                flage = false;
                                break;
                            }
                        }
                        if(flage){
                            maxEdg = Math.max(maxEdg,k+1);
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return maxEdg*maxEdg;

    }
}