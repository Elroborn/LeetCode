import java.util.ArrayList;
import java.util.List;

/*
 * @Author: your name
 * @Date: 2020-09-15 11:49:27
 * @LastEditTime: 2020-09-15 11:56:35
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \leetcode\剑指 Offer 62. 圆圈中最后剩下的数字\Solution.java
 */
class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> circle = new ArrayList<>();
        int index = 0;
        for(int i = 0;i<n;i++){
            circle.add(i);
        }
        while(circle.size()>1){
            index = (index+m-1)%circle.size();
            circle.remove(index);
        }
        return circle.get(0);
    }
    public static void main(String[] args) {
        System.out.println(new Solution().lastRemaining(10, 17));
    }
}