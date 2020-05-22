class Solution {
    int res = Integer.MAX_VALUE;
    public int superEggDrop(int K, int N) {
        dp(K, N);
        return res;
    }
    public int dp(int K,int N){ // k个蛋，N层楼
        if(K==1){ //只能线性扫描
            return N;
        }
        if(N==0){
            return 0;
        }
        for(int i=1;i<=N;i++){ //一层层尝试
            res = Math.min(res,Math.max(dp(K-1,i-1), dp(K,N-i)) +1); //蛋碎和没碎
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().superEggDrop(3, 14));
    }
}