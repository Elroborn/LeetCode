import java.util.ArrayList;
import java.util.List;
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-18 10:27:45
 * @FilePath: \leetcode\131_分割回文串\Solution.java
 * @LastEditTime: 2020-08-18 10:34:27
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        if(s== null || s.length() == 0){
            return res;
        }
        dfs(res,tmp,s);    
        return res;
    }
    public void dfs(List<List<String>> res,List<String> tmp ,String s){
        if(s.length() ==0){
            res.add(new ArrayList<>(tmp));
        }
        for(int i = 0;i<s.length();i++){
            if(isHui(s,0,i)){
                tmp.add(s.substring(0,i+1));
                dfs(res, tmp, s.substring(i+1));
                tmp.remove(tmp.size() -1);
            }
        }
    }
    public boolean isHui(String s ,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
    
}