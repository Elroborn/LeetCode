import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        HashMap<String,List<String>> map = new HashMap<>();
        for(int i = 0;i<strs.length;i++){
            int[] encode = new int[26]; // 原本要排序，不过因为字母个数有限，则直接用桶装即可，将桶的结果编码
            for(char c:strs[i].toCharArray()){
                encode[c-'a'] ++;
            }
            StringBuilder sb = new StringBuilder();
            for(int c:encode){
                sb.append(c);
            }
            String key = sb.toString();
            List<String> v = map.getOrDefault(key,new ArrayList<>());
            v.add(strs[i]);
            map.put(key, v);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,List<String>> mm:map.entrySet()){
            res.add(mm.getValue());
        }
        return res;
    }
    public static void main(String[] args) {
        String[] strs =  {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution().groupAnagrams(strs));
    }
}