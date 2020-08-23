/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-23 15:53:14
 * @FilePath: \leetcode\303_区域和检索 - 数组不可变\NumArray.java
 * @LastEditTime: 2020-08-23 15:56:19
 */
class NumArray {
    int[] nums;
    int[] preSum;
    public NumArray(int[] nums) {
        this.nums = nums;
        preSum = new int[nums.length +1];
        for(int i = 1;i<=nums.length;i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return preSum[j+1] - preSum[i];
    }
    public static void main(String[] args) {
        int[] nums = {2,4,3,1};
        System.out.println(new NumArray(nums).sumRange(1, 3));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */