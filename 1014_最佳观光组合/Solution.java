class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int res = Integer.MIN_VALUE;
        // for(int i =0;i<A.length;i++){
        //     for(int j = i+1;j<A.length;j++){
        //         int t = A[j] + A[i] - (j-i);
        //         res = Math.max(res, t);
        //     }
        // }
        // 转化为A[i] + i + A[j] - j 这样求第j个位置是，其实找到max(A[i]+i) 即可，这个可以在遍历时候维护
        int A_max = A[0]+0;
        for(int j = 1;j<A.length;j++){
            res = Math.max(A_max+A[j]-j, res);
            A_max = Math.max(A_max, A[j]+j);
        }
        return res;

    }
}