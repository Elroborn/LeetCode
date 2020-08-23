/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-23 14:09:00
 * @FilePath: \leetcode\201_数字范围按位与\Solution.java
 * @LastEditTime: 2020-08-23 15:19:09
 */
// https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/shu-zi-fan-wei-an-wei-yu-by-leetcode-solution/
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while(m<n){
            m>>=1; //找公共前缀 右移就是把右边的移掉
            n>>=1;
            shift++;
        }
        return m<<shift;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().rangeBitwiseAnd(5,7));
    }
}