import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o2[1]-o1[1]:o1[0] - o2[0];
            }
        });
        int[] h = new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            h[i] = envelopes[i][1];
        }
        return LIS(h);
    }
    public int LIS(int[] array){
        int[] dp = new int[array.length];
        for(int i=0;i<array.length;i++){
            dp[i] = 1;
        }
        for(int i=0;i<array.length;i++){
            for(int j=0;j<i;j++){
                if(array[j]<array[i]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
        }
        int res = 0;
        for(int i=0;i<dp.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}