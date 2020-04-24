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

    int waysToChange2(int n) {
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
    // https://leetcode-cn.com/problems/coin-lcci/solution/jie-fang-cheng-jiu-dui-liao-lai-de-zei-kuai-shi-ji/
    int waysToChange(int n) {
        int ans = 0;
        for (int a = 0; a <= n / 25; a ++) {
            // 将循环展开用数学表示，对于c那一层，直接用(n-25*a-10*b)/5 +1 = n/5-5*a-2b+1表示，而b那一层，则对上面那个式子，如果和b无关的变量，直接循环
            // bmax次，相关的变量，其实就是等差数列
            long b_range = (n-25*a)/10 +1;
            // long t = b_range * (n/5) -5*a * b_range +b_range - 2*((0+b_range-1)*b_range/2);
            long t = (b_range * (n/5) -5*a * b_range +b_range - b_range*(b_range-1))%1000000007;
            ans = (ans+(int)t)%1000000007;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().waysToChange(900750));
    }
}