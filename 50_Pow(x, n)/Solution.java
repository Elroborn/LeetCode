/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-05-03 09:49:18
 * @FilePath: \leetcode\50_Pow(x, n)\Solution.java
 * @LastEditTime: 2020-08-21 11:07:57
 */
class Solution {
    public double myPow(double x, int n) {
        if(n>=0){
            return helper(x,n);
        }else{
            return 1.0/helper(x,-n);
        }
    }
    public double helper(double x,int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        double t = helper(x,n/2);
        if(n%2==0){
            return t*t;
        }else{
            return t*t*x;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2,-1));
    }
}