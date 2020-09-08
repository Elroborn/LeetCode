import java.util.ArrayList;
import java.util.List;
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-08 09:28:15
 * @FilePath: \leetcode\77_组合\Solution1.java
 * @LastEditTime: 2020-09-08 10:24:35
 */
class Solution1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(res,tmp,1,k,n);
        return res;
    }
    public void dfs(List<List<Integer>> res,List<Integer> tmp,int start,int k,int n){
        if(tmp.size()==k){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = start;i<=n;i++){
            tmp.add(i);
            dfs(res, tmp, i+1, k, n);
            tmp.remove(tmp.size()-1);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> res = new Solution1().combine(4,2);
        System.out.println(res.toString());
    }
}