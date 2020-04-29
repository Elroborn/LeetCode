import java.util.HashMap;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                map.put(-(A[i]+B[j]), map.getOrDefault(-(A[i]+B[j]), 0)+1);
            }
        }
        for(int k =0;k<C.length;k++){
            for(int l=0;l<D.length;l++){
                if(map.containsKey(C[k]+D[l])){
                    res+=(map.get(C[k]+D[l]));
                }

            }
        }
        return res;
    }
    public static void main(String[] args) {
        int [] A = {1,2},B = {-2,-1},C = {-1, 2},D = {0, 2};
        System.out.println(new Solution().fourSumCount(A, B, C, D));

    }
}