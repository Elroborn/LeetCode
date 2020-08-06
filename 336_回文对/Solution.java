import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-06 10:01:36
 * @FilePath: \leetcode\336_回文对\Solution.java
 * @LastEditTime: 2020-08-06 10:12:38
 */
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<words.length;i++){
            for(int j = 0;j<words.length;j++){
                if(i!=j && isHuiwen(words[i]+words[j])){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    public boolean isHuiwen(String s){
        int i = 0,j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        new Solution().palindromePairs(words);
    }
}