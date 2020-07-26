/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-22 10:05:51
 * @FilePath: \leetcode\剑指 Offer 11. 旋转数组的最小数字\Solution.java
 * @LastEditTime: 2020-07-22 10:27:57
 */ 
class Solution {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        int mid = 0;
        while(left < right){
            // 之所以用right做判断，是因为对于left而言 num[mid] > num[left] 不能说明最小值的位置，因为对于左边而言有序可能是最小在左边，也可能是旋转了，最小在右边
            mid = left + (right - left) /2;
            if(numbers[mid] > numbers[right]){ // 左有序
                left = mid + 1; // 因为mid肯定不是最小
            }else if(numbers[mid] < numbers[right]){
                right = mid;
            }else{ //说明mid 和lright相等，所以缩小规模right - 1 因为无论number[right]是不是最小值，都会有num[mid]相对应
                right = right - 1;
            }
        }
        return numbers[left];
    }
}