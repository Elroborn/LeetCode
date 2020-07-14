/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-14 14:37:48
 * @FilePath: \leetcode\605_种花问题\Solution.java
 * @LastEditTime: 2020-07-14 14:48:11
 */ 
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for(int i = 0;i<flowerbed.length && cnt<n; i++){
            if(flowerbed[i]==1){
                continue;
            }
            int pre = (i==0?0:flowerbed[i-1]);
            int next = (i==flowerbed.length -1?0:flowerbed[i+1]);
            if(pre==0 && next ==0){
                flowerbed[i] = 1;
                cnt++;
            }
        }
        return cnt>=n;

    }
}