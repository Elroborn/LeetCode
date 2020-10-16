import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-14 09:28:35
 * @FilePath: \leetcode\1002. 查找常用字符\Solution.java
 * @LastEditTime: 2020-10-14 09:47:40
 */
class Solution {
    public List<String> commonChars(String[] A) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        List<String> res = new ArrayList<>();
        for(String s:A){
            int[] freq = new int[26];
            for(char c:s.toCharArray()){
                freq[c-'a']++;
            }
            for(int i = 0;i<26;i++){
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }
        for(int i = 0;i<26;i++){
            for(int t=0;t<minFreq[i];t++){
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;

    }
}