class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1 || n==2){
            return n;
        }
        int n_2 = 1,n_1 = 2;
        int res = 0;
        for(int i=3;i<=n;i++){
            res = n_1 + n_2;
            n_2 = n_1;
            n_1 = res;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(4));
    }
}