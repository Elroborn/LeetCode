import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int[] tmp = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=tmp[1]){
                tmp[1] = Math.max(intervals[i][1],tmp[1]);
            }else{
                list.add(intervals[i]);
                tmp = intervals[i];
            }
        }
        int[][] r = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            r[i] = list.get(i);
        }
        return r;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = new Solution().merge(intervals);
        System.out.println(res[1][0]);
        System.out.println(res[1][1]);
    }
}