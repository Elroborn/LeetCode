/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-16 15:54:12
 * @FilePath: \leetcode\977_有序数组的平方\Solution.java
 * @LastEditTime: 2020-10-16 16:10:28
 */
class Solution {
    public int[] sortedSquares(int[] A) {
        int minus_index = 0;
        for(int i = 0;i<A.length;i++){
            if(A[i]<0){
                minus_index = i;
            }
            A[i]*= A[i];
        }
        int[] res = new int[A.length];
        int i = minus_index+1;
        int j = minus_index;
        int index = 0;
        while(i<A.length && j>=0){
            if(A[i]<A[j]){
                res[index++] = A[i++];
            }else{
                res[index++] = A[j--];
            }
        }
        while(i<A.length){
            res[index++] = A[i++];
        }
        while(j>=0){
            res[index++] = A[j--];
        }
        return res;
    }
}