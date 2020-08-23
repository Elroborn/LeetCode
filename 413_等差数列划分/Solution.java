/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-23 16:09:04
 * @FilePath: \leetcode\413_等差数列划分\Solution.java
 * @LastEditTime: 2020-08-23 16:12:03
 */
// dp[i] 表示以 A[i] 为结尾的等差递增子区间的个数。

// 当 A[i] - A[i-1] == A[i-1] - A[i-2]，那么 [A[i-2], A[i-1], A[i]] 构成一个等差递增子区间。
// 而且在以 A[i-1] 为结尾的递增子区间的后面再加上一个 A[i]，一样可以构成新的递增子区间。
// dp[2] = 1
// [0, 1, 2]
// dp[3] = dp[2] + 1 = 2
// [0, 1, 2, 3], // [0, 1, 2] 之后加一个 3
// [1, 2, 3]     // 新的递增子区间
// dp[4] = dp[3] + 1 = 3
// [0, 1, 2, 3, 4], // [0, 1, 2, 3] 之后加一个 4
// [1, 2, 3, 4],    // [1, 2, 3] 之后加一个 4
// [2, 3, 4]        // 新的递增子区间
// 综上，在 A[i] - A[i-1] == A[i-1] - A[i-2] 时，dp[i] = dp[i-1] + 1。

// 因为递增子区间不一定以最后一个元素为结尾，可以是任意一个元素结尾，因此需要返回 dp 数组累加的结果。
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        for(int i = 2;i<A.length;i++){
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                dp[i] = dp[i-1] +1; // +1 就是产生的新的长度为三的
            }
        }
        int res = 0;
        for(int t:dp){
            res+=t;
        }
        return res;
    }
}