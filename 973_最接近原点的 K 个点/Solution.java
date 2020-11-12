import java.util.Arrays;
import java.util.Comparator;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-11-09 08:37:40
 * @FilePath: \leetcode\973_最接近原点的 K 个点\Solution.java
 * @LastEditTime: 2020-11-09 08:45:59
 */
// 或者直接对points排序，只是排序规则变味了欧氏距离相减
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] dis = new int[points.length][2];
        int i = 0;
        for(int[] point:points){
            dis[i][0] = point[0]*point[0] + point[1]*point[1];
            dis[i][1] = i;
            i++;
        }
        Arrays.sort(dis, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }

        });
        int[][] res = new int[K][2];
        for(i = 0;i<K;i++){
            res[i] = points[dis[i][1]];
        }
        return res;
    }
}