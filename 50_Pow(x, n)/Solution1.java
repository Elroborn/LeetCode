/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-21 11:10:57
 * @FilePath: \leetcode\50_Pow(x, n)\Solution1.java
 * @LastEditTime: 2020-08-21 14:25:36
 */
class Solution1 {
    public double myPow(double x, int n) {
        long N = n; // 用快速幂这个地方一定要修改为long
        return N >= 0 ? Fast_pow(x, N) : 1.0 / Fast_pow(x, -N);
    }
    // 快速幂 n是>0
    public double Fast_pow(double x,long n){
        //因为任意一个数都能转换为2进制，也就是可以a^n -> a^(2^0+2^2+2^..)->a^(2^0) * a^(2^2) *a^(2^..)
        // 所以只需要把n二进制化即可，在n%2==1的时候往结果里面乘
        double res = 1;
        while(n>0){
            if(n%2==1){
                res *=x;
            }
            x*=x;
            n/=2;
        }
        return res;
        
    }
    public static void main(String[] args) {
        System.out.println(new Solution1().myPow(3, 4));
    }
}