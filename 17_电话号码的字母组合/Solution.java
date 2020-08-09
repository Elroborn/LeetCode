import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-08 11:15:22
 * @FilePath: \leetcode\17_电话号码的字母组合\Solution.java
 * @LastEditTime: 2020-08-09 11:08:57
 */
class Solution {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList();
        if(digits==null || digits.length() ==0){
            return res;
        }
        dfs(digits, 0, "");
        return res;
    }
    private void dfs(String digits,int i,String sb){
        if(i==digits.length()){
           res.add(sb);
           return ;
        }
        for(char c:KEYS[digits.charAt(i)-'0'].toCharArray()){
            dfs(digits, i+1, sb+c);
        }

    }
    public static void main(String[] args) {
        String digits = "23";
        for(String s:new Solution().letterCombinations(digits)){
            System.out.println(s);
        }
    }
}