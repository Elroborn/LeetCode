import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-31 11:02:19
 * @FilePath: \leetcode\127_单词接龙\Solution.java
 * @LastEditTime: 2020-07-31 11:27:29
 */ 
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == endWord){
            return 1;
        }

        Queue<String> queue  = new LinkedList<>();
        HashSet<String> set = new HashSet<>(); //可以用来减枝
        int res = 0;
        queue.add(beginWord);
        set.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            res++;
            for(int i = 0;i<size;i++){ //遍历一层
                String tmp = queue.poll();
                // System.out.println(tmp);
                if(tmp==endWord){
                    return res;
                }
                for(String w:wordList){
                    if(isOk(tmp,w) && !set.contains(w)){
                        queue.add(w);
                        set.add(w); //避免有些字符串已经在树的上层经过了，那么再下层没必要再次遍历
                    }
                }
            }
        }
        return -1;
        
    }
    public boolean isOk(String tmp,String w){
        // 看tmp是否能够经过一步到达w
        int diff = 0;
        for(int i = 0;i<tmp.length();i++){
            if(tmp.charAt(i)!= w.charAt(i)){
                diff++;
                if(diff>1){
                    return false;
                }
            }
        }
        return diff<2;
    }
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        String[] wl = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(wl);
        System.out.println(new Solution().ladderLength(beginWord, endWord, wordList));
    }
}