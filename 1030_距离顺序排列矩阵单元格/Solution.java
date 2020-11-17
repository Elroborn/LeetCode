import java.util.Arrays;
import java.util.Comparator;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-11-17 19:26:13
 * @FilePath: \leetcode\1030_距离顺序排列矩阵单元格\Solution.java
 * @LastEditTime: 2020-11-17 19:35:53
 */
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R*C][2];
        int index = 0;
        // 最大距离有限制，所以可以在遍历的时候通过桶排序顺带排序，可以节省下面排序耗时
        for(int i = 0;i<R;i++){
            for(int j = 0;j<C;j++){
                res[index++] = new int[]{i,j};
            }
        }
        Arrays.sort(res,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
                int l1 = Math.abs(o1[0] -r0) + Math.abs(o1[1] -c0);
                int l2 = Math.abs(o2[0] -r0) + Math.abs(o2[1] -c0);
				return l1-l2;
			}
        });
        return res;

    }
}