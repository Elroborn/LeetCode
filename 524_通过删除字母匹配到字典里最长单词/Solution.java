/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-05 11:06:03
 * @FilePath: \leetcode\524_通过删除字母匹配到字典里最长单词\Solution.java
 * @LastEditTime: 2020-07-05 11:34:08
 */ 
import java.util.List;
class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for(String p:d){
            if(res.length() > p.length() || (res.length() == p.length() && res.compareTo(p)<0)){
                continue; //即使p可以，但是res也是最优的
            }
            if(helper(s, p)){
                res = p;
            }
        }
        return res;
    }
    public boolean helper(String s,String p){ //将s删除字母是否能够匹配到p
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == p.length();
        
    }
    public static void main(String[] args) {
//         "bab"
// ["ba","ab","a","b"]
        // System.out.println("a".compareTo("b"));
        System.out.println(new Solution().helper("aewfafwafjlwajflwajflwafj", "awef"));
    }
}