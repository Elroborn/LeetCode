/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-08 15:19:38
 * @FilePath: \leetcode\面试题 16.11. 跳水板\Solution.java
 * @LastEditTime: 2020-07-08 15:28:35
 */ 
class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){
            return new int[0];
        }
        if(shorter ==longer){
            //相当于用了k个同样的板子，结果只能是k*shor..
            return new int[]{k*shorter};
        }
        int[] res = new int[k+1];
        for(int l = 0;l<=k;l++){
            res[l] = longer * l + (k-l) * shorter;
        }
        return res;
    }
}