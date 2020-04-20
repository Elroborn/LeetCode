import java.util.ArrayList;
import java.util.Collections;;
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null ||matrix.length==0){
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int res[] = new int[row*col];
        ArrayList<Integer> tmp = new ArrayList<>();
        int k = 0;
        for(int d = 0;d<row+col-1;d++){ //按对角线层数遍历，因为非方阵，你可以（3*5）模拟一下，首位元素是第一行所有以及最后一列所有
            tmp.clear();
            //找到每层的首位元素，之后就按照对角线方向遍历即可，如果奇数层则reverse一下
            int r = (d<col)?0:(d-col+1); //每层的首位，如果前col层，则都都是0（第一行），否则d-col
            int c = (d<col)?d:col-1;
            while(r<row && c>=0){
                tmp.add(matrix[r][c]);
                r++;
                c--; //对角线方向
            }
            if(d%2==0){ //偶数需要reverse
                Collections.reverse(tmp);
            }
            for(int n:tmp){
                res[k++] = n;
            }

        }
        return res;

    }
    public static void main(String[] args) {
        int [][]matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        int []res = new Solution().findDiagonalOrder(matrix);
        for(int i:res){
            System.out.println(i);
        }
        
    }
}