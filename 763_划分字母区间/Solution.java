/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-19 11:06:06
 * @FilePath: \leetcode\763_划分字母区间\Solution.java
 * @LastEditTime: 2020-07-19 11:18:34
 */ 

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for(int i = 0;i<S.length();i++){
            last[S.charAt(i)-'a'] = i; // 一直保持是最后一个
        }
        int j = 0,anchor = 0;
        List<Integer> ans = new ArrayList();
        for(int i = 0;i<S.length();i++){
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if(i==j){ //i==j 说明这个区间里面所有的字符的最后一个都在[anchor,j]里面
                ans.add(i- anchor +1);
                anchor = i+1;
            }
        }
        return ans;


    }
}