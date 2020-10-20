/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-19 09:20:17
 * @FilePath: \leetcode\剑指 Offer 15. 二进制中1的个数\Solution1.java
 * @LastEditTime: 2020-10-19 09:25:08
 */
public class Solution1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 如果直接每次n右移，则对于负数会出现溢出，所以在java可以用>>>
        //如果不想用>>> 则可以考虑用一个1不断左移和n做与即可

        // 原来是n动，1不动，现在变成1动，n不动，因为1你可以保证是非负数，所以不会死循环
        int flage = 1;
        int cnt = 0;
        while(flage!=0){
            if((flage&n)!=0){
                cnt++;
            }
            flage<<=1;
        }
        return cnt;
    }
}