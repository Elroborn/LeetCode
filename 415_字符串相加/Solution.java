/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-03 10:19:47
 * @FilePath: \leetcode\415_字符串相加\Solution.java
 * @LastEditTime: 2020-08-03 14:35:54
 */ 
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int i = num1.length() -1, j = num2.length() -1;
        while(i>=0 && j>=0){
            int t1 = num1.charAt(i) - '0';
            int t2 = num2.charAt(j) - '0';
            sb.append((t1+t2+cnt)%10);
            cnt = (t1+t2+cnt) /10;
            i--;j--;
        }
        while(i>=0){
            int t1 = num1.charAt(i) - '0';
            sb.append((t1+cnt)%10);
            cnt = (t1+cnt) /10;
            i--;
        }
        while(j>=0){
            int t1 = num2.charAt(j) - '0';
            sb.append((t1+cnt)%10);
            cnt = (t1+cnt) /10;
            j--;
        }
        if(cnt!=0){
            sb.append(cnt);
        }
        return sb.reverse().toString();

    }
    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("123", "98"));
    }
}