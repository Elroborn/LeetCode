/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-02 11:07:22
 * @FilePath: \leetcode\836_矩形重叠\Solution.java
 * @LastEditTime: 2020-08-02 11:15:58
 */ 
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // x1 y1 x2 y2
        int inner_x1 = Math.max(rec1[0], rec2[0]);
        int inner_x2 = Math.min(rec1[2], rec2[2]);
        int inner_w = inner_x2 - inner_x1;
        
        int inner_y1 = Math.max(rec1[1], rec2[1]);
        int inner_y2 = Math.min(rec1[3], rec2[3]);
        int inner_h = inner_y2 - inner_y1;

        if(inner_w<=0 || inner_h<=0){
            return false;
        }else{
            return true;
        }


    }
}