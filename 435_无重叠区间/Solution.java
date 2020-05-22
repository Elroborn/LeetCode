import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //先找最多几个不重叠区间，然后n- 即可
        if(intervals.length ==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1]; // 按照end排序
            }
        });
        int cnt = 1;
        int end = intervals[0][1]; //
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=end){ //不重叠
                cnt++;
                end = intervals[i][1];
            }
        }
        return intervals.length - cnt;
    }
}