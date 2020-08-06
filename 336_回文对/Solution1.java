import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-06 10:01:36
 * @FilePath: \leetcode\336_回文对\Solution1.java
 * @LastEditTime: 2020-08-06 11:34:09
 */
// https://leetcode-cn.com/problems/palindrome-pairs/solution/hui-wen-dui-by-leetcode-solution/
class Solution1 {
    Map<String,Integer> map;
    public List<List<Integer>> palindromePairs(String[] words) {
        map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<words.length;i++){
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        for(int i = 0;i<words.length;i++){
            String st = words[i];
            int m = st.length();
            if(m==0){
                continue;
            }
            for(int j = 0;j<=m;j++){ // 保证k是最长的，然后把k分为两部分 t1 和t2 如果t1回文则找t2,看t2是否在map里面（如果在代表t2的reverse在word里面就是可以的），然后拼接成
                if(j!=0 && isHuiwen(st, 0, j-1)){
                    int left = findWord(st, j, m-1);
                    if(left!=-1 && left!=i){
                        res.add(Arrays.asList(left,i));
                    }
                }
                if(isHuiwen(st, j, m-1)){
                    int right = findWord(st, 0, j-1);
                    if(right!=-1 && right!=i){
                        res.add(Arrays.asList(i,right));
                    }
                }
            }
        }
        return res;

    }
    public boolean isHuiwen(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int findWord(String s, int left, int right) {
        return map.getOrDefault(s.substring(left, right + 1), -1);
    }

    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        new Solution().palindromePairs(words);
    }
}