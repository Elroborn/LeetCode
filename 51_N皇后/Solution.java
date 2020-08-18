import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-18 10:42:08
 * @FilePath: \leetcode\51_N皇后\Solution.java
 * @LastEditTime: 2020-08-18 11:07:15
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] tmp = new int[n];
        Arrays.fill(tmp, -1);
        dfs(res,tmp,0,n);
        return res;
    }
    public void dfs(List<List<String>> res,int[] tmp,int start,int n){
        if(start ==n){
            // for(int i:tmp){
            //     System.out.printf("%d ",i);
            // }
            // System.out.println();
            res.add(build(tmp));
            return ;
        }
        for(int i = 0;i<n;i++){
            if(isOk(tmp,start,i) && tmp[start]==-1){
                tmp[start] = i;
                dfs(res,tmp, start+1, n);
                tmp[start] = -1;
            }
        }
    }
    // 看start行是否能在i列放棋子
    public boolean isOk(int[] res,int start,int i){
        for(int k = 0;k<start;k++){
            if(res[k] == i || Math.abs(start - k) == Math.abs(res[k]-i)){
                return false;
            }
        }
        return true;
    }
    public List<String> build(int[] tmp){
        List<String> res = new ArrayList<>();
        for(int i = 0;i<tmp.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0;j<tmp.length;j++){
                if(j!=tmp[i]){
                    sb.append(".");
                }else{
                    sb.append("Q");
                }
            }
            res.add(sb.toString());
        }
        return res;
        
    }
    public static void main(String[] args) {
        new Solution().solveNQueens(4);
    }
}