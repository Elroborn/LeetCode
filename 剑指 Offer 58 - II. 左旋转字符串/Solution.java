/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-06 10:47:00
 * @FilePath: \leetcode\剑指 Offer 58 - II. 左旋转字符串\Solution.java
 * @LastEditTime: 2020-09-06 10:54:58
 */
class Solution {
    //或者先部分翻转，再整体翻转
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0;i<n;i++){
            // sb.append(sb.charAt(0));
            // sb.deleteCharAt(0);
            sb.append(sb.charAt(i)); //因为delet也比较耗费时间，所以干脆最后统一一次substring
        }
        return sb.toString().substring(n);
    }
    public static void main(String[] args) {
        System.out.println(new Solution().reverseLeftWords("abcdefg", 2));
    }
}