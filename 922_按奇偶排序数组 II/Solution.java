/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-11-12 09:06:52
 * @FilePath: \leetcode\922_按奇偶排序数组 II\Solution.java
 * @LastEditTime: 2020-11-12 09:31:12
 */
class Solution {
    // public int[] sortArrayByParityII(int[] A) {
    //     //会死循环 2 3 1 1 4 0 0  4 3 3 双指针的作用主要起到将数据分为两类，一个指针表示一类，而你下面的做法，i和j并没有代表两类，所以不可
    //     // int i = 0 ,j = A.length -1;
    //     // while(i<j){
    //     //     while(i<j && ((i%2==0 && A[i]%2==0) || (i%2!=0 && A[i]%2!=0))){
    //     //         i++;
    //     //     }
    //     //     while(i<j && ((j%2==0 && A[j]%2==0) || (j%2!=0 && A[j]%2!=0))){
    //     //         j--;
    //     //     }
    //     //     int t = A[i];
    //     //     A[i] = A[j];
    //     //     A[j] = t;
    //     // }
    //     // return A;

    //     //两次遍历，把A中所有偶数先放到ans[0] ans[2] 。。里面，奇数放到ans[1] ans[3]里面
    //     int i = 0, j = 1;
    //     int[] ans = new int[A.length];
    //     for(int t:A){
    //         if(t%2==0){
    //             ans[i] = t;
    //             i+=2;
    //         }else{
    //             ans[j] = t;
    //             j+=2;
    //         }
    //     }
    //     return ans;
    // }
    public int[] sortArrayByParityII(int[] A) {
        int j = 1; // j代表的是奇数
        for(int i = 0;i<A.length;i+=2){
            while(A[i]%2!=0){
                int t = A[j];
                A[j] = A[i];
                A[i] = t;
                j+=2;
            }
        }
        return A;

    }
}