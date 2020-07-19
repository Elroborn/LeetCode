/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-15 21:14:14
 * @FilePath: \leetcode\96_不同的二叉搜索树\Solution.java
 * @LastEditTime: 2020-07-16 20:04:24
 */ 
class Solution {
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j = 1;j<=i;j++){
                G[i] += G[j-1] *G[i-j];
            }
        }
        return G[n];
    }
}