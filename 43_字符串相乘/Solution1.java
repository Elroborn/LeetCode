/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-13 10:08:28
 * @FilePath: \leetcode\43_字符串相乘\Solution1.java
 * @LastEditTime: 2020-08-13 10:46:54
 */
class Solution1  {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for(int i = num1.length() -1;i>=0 ;i--){
            for(int j = num2.length()- 1;j>=0;j--){
                int t = (num1.charAt(i)-'0') * (num2.charAt(j) - '0');
                int p1 = i + j+1;
                int p2 = i+j;
                int s = t + res[p1];
                res[p1] = s%10; // 这个地方因为之前+过了，所以不是+=
                res[p2] += s/10;
            }
        }
        int j = 0;
        for(;j<res.length;j++){
            if(res[j]!=0){
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(;j<res.length;j++){
            sb.append(res[j]);
        }
        return sb.length()==0?"0":sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Solution1().multiply("99","99"));
    }
}