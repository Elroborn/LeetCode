/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-01 11:03:29
 * @FilePath: \leetcode\167_两数之和 II - 输入有序数组\Solution1.java
 * @LastEditTime: 2020-07-20 11:07:28
 */ 
class Solution1 {
    // public int[] twoSum(int[] numbers, int target) {
    //     //本身升序
    //     int i = 0;
    //     int j = numbers.length-1;
    //     int t = 0;
    //     while(i<j){
    //         t = numbers[i]+numbers[j];
    //         if(t==target){
    //             return new int[]{i+1,j+1};
    //         }else if(t<target){
    //             //则需要变大，因为数组升序，所以把i++, 如果是移动的j--则最终结果是变小的
    //             i++;
    //         }else{
    //             j--;
    //         }
    //     }
    //     return new int[]{-1,-1};

    // }

    public int[] twoSum(int[] numbers, int target) {
        // 有序两个数 考虑双指针
        int i = 0, j  = numbers.length - 1;
        int t = 0;
        while(i<j){
            t = numbers[i] + numbers[j];
            if(t == target){
                return new int[]{i+1,j+1};
            }else if(t>target){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{-1,-1};
    }
}