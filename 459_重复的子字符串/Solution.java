/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-24 10:43:14
 * @FilePath: \leetcode\459_重复的子字符串\Solution.java
 * @LastEditTime: 2020-08-24 10:59:53
 */
class Solution {
    public boolean repeatedSubstringPattern1(String s) {
        int n = s.length();
        // i 代表枚举所有可能的长度
        for(int i = 1;i*2<=n;i++){
            boolean flage = true;
            if(n%i==0){ // 要重复，肯定是倍数关系
                // 判断所有的j -i 和j是否等（就是所有子串是否重复）
                for(int j = i;j<n;j++){
                    if(s.charAt(j)!=s.charAt(j-i)){
                        flage = false;
                        break;
                    }
                }
                if(flage){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
 
    }
}