import java.util.ArrayList;
import java.util.HashMap;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-07 10:32:13
 * @FilePath: \leetcode\451_根据字符出现频率排序\Solution.java
 * @LastEditTime: 2020-07-07 10:42:45
 */ 
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1); // 每个字符的频率
        }
        // 字符频率排序用桶排序  因为一个频率可能对应多个字符，所以用ArrayList
        ArrayList<Character>[] buck = new ArrayList[s.length()+1];
        for(Character key:map.keySet()){
            Integer fre = map.get(key);
            if(buck[fre]==null){
                buck[fre] = new ArrayList<Character>();
            }
            buck[fre].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = s.length();i>=0;i--){
            if(buck[i]!=null){
                for(Character c:buck[i]){
                    for(int t=0;t<i;t++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}