import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0,j = 0;
        List<int[]> list = new ArrayList<>();
        while(i<A.length && j<B.length){
            int a1 = A[i][0];
            int a2 = A[i][1];
            int b1 = B[j][0];
            int b2 = B[j][1];
            if(a2>=b1 && b2>=a1){
                int []tmp = {Math.max(a1, b1),Math.min(a2, b2)};
                list.add(tmp);
            }

            if(b2<a2){
                j++;
            }else{
                i++;
            }
        }
        int[][] res = new int[list.size()][2];
        for(i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;

    }
}