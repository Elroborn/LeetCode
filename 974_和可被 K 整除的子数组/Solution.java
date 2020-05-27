import java.util.HashMap;
import java.util.Map;

class Solution {
    //超时
    public int subarraysDivByK1(int[] A, int K) {
        int[] preSum = new int[A.length+1];
        preSum[0] = 0;
        for(int i=0;i<A.length;i++){
            preSum[i+1] = preSum[i] + A[i];
        }
        int cnt = 0;
        for(int i=0;i<A.length;i++){
            for(int j=i;j<A.length;j++){
                int sum = preSum[j+1] -preSum[i];
                if(sum%K==0){
                    cnt++;
                }

            }
        }
        return cnt;
    }
    // 计算preSum[j+1] -preSum[i] %K ==0 即 preSum[j+1]%K == preSum[j]%K，即统计各个出现的次数即可
    // 比如preSum[3]%K =5  preSum[6]%K =5 preSum[7]%K =5  则区间3-6 3-7 6-7 都满足条件
    public int subarraysDivByK(int[] A, int K) {
        int[] preSum = new int[A.length+1];
        preSum[0] = 0;
        for(int i=0;i<A.length;i++){
            preSum[i+1] = preSum[i] + A[i];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<=A.length;i++){
            int t = (preSum[i]%K+K) %K;
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        int cnt = 0;

        for(Integer v:map.values()){
            int t = v*(v-1)/2;
            cnt +=t;
        }

        return cnt;
    }
    public static void main(String[] args) {
        int[] A = {4,5,0,-2,-3,1};
        int K = 5;
        System.out.println(new Solution().subarraysDivByK(A, K));
    }
}