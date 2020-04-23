class Solution {
    //先用暴力试一下 n = 25*a+10*b+5c+d
    public int waysToChange1(int n) {
        int res = 0;
        for(int a=0;a<=n/25;a++){
            for(int b = 0;b<=(n-25*a)/10;b++){
                for(int c = 0;c<=(n-25*a-10*b)/5;c++){
                    res++;
                    res = res%1000000007;
                }
            }
        }
        return res%1000000007;
    }

    int waysToChange(int n) {
        int ans = 0;
        for (int i = 0; i <= n / 25; i ++) {
            int rest = n - i * 25;
            int p = rest / 5;
            int q = rest / 10;
            ans += (long)(p + 1)*(q + 1) % 1000000007 - (long)q*(q + 1)% 1000000007;
            ans %= 1000000007;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().waysToChange(900750));
    }
}