/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-23 09:58:50
 * @FilePath: \leetcode\剑指 Offer 16. 数值的整数次方\Solution.java
 * @LastEditTime: 2020-10-23 10:13:01
 */
class Solution {
    public double myPow(double x, int n) {
        if(x==0){
            return 0;
        }
        if(n==0 || x==1){
            return 1;
        }
        if(n<0){ // 如果n是MINVALUE 则-n会溢出还是MINVALUE，所以需要简单处理一下
            return 1 / x * myPow(1 / x, -n - 1);
        }
        if(n==1){
            return x;
        }
        if(n%2==0){
            double t = myPow(x, n/2);
            return t*t;
        }
        if(n%2!=0){
            double t = myPow(x, n/2);
            return t*t*x;
        }
        return -1; //无意义
    }
    public static void main(String[] args) {
        // System.out.println(new Solution().myPow(2,-2147483648));
        int n = -2147483648;
        System.out.println(n);
        System.out.println(-n-1);
    }
}