import java.util.Arrays;
import java.util.Comparator;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-09 14:26:09
 * @FilePath: \leetcode\435_无重叠区间\Solution1.java
 * @LastEditTime: 2020-07-09 14:34:35
 */
class Solution1 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        if(intervals.length==0){
            return res;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        res =1;
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=end){
                res++;
                end = intervals[i][1];
            }
        }
        return intervals.length - res;
    }
}