/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-09 14:44:47
 * @FilePath: \leetcode\剑指 Offer 66. 构建乘积数组\Solution.java
 * @LastEditTime: 2020-07-09 15:36:16
 */ 
class Solution {
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        int[] pre = new int[a.length];
        int[] bac = new int[a.length];
        if(a.length==0){
            return res;
        }
        pre[0] = a[0];
        bac[a.length-1] = a[a.length-1];
        for(int i =1;i<a.length;i++){
            pre[i] = a[i] * pre[i-1];
            bac[a.length-1-i] = a[a.length - 1 -i] * bac[a.length - i];
        }
        for(int i = 0;i<res.length;i++){
            res[i] =1;
            int left = i-1;
            int right = i+1;
            if(left>=0){
                res[i]*=pre[left];
            }
            if(right<bac.length){
                res[i]*=bac[right];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        new Solution().constructArr(a);
    }
}