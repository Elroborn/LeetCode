/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-11-03 09:12:51
 * @FilePath: \leetcode\941_有效的山脉数组\Solution.java
 * @LastEditTime: 2020-11-03 09:20:14
 */
class Solution {
    public boolean validMountainArray(int[] A) {
        int i = 0;
        while(i+1<A.length && A[i+1]>A[i]){
            i++;
        }
        if(i==0 || i==A.length -1){
            return false;
        }
        while(i+1<A.length && A[i+1]<A[i]){
            i++;
        }
        return i == A.length -1;

    }
}