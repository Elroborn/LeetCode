import java.util.Arrays;
import java.util.HashSet;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-02 10:40:53
 * @FilePath: \leetcode\345_反转字符串中的元音字母\Solution.java
 * @LastEditTime: 2020-07-02 10:53:29
 */ 
class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int i = 0;
        int j = ch.length-1;
        boolean flag_i = false;
        boolean flag_j = false;
        while(i<j){
            flag_i = set.contains(ch[i]);
            flag_j = set.contains(ch[j]);
            if(flag_i && flag_j){
                char t = ch[i];
                ch[i] = ch[j];
                ch[j] = t;
                i++;
                j--;
            }
            if(!flag_i){
                i++;
            }
            if(!flag_j){
                j--;
            }
        }
        return new String(ch);
    }
}