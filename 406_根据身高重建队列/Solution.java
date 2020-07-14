/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-13 10:23:43
 * @FilePath: \leetcode\406_根据身高重建队列\Solution.java
 * @LastEditTime: 2020-07-13 10:48:36
 */ 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1,int[]o2){
                return (o1[0]==o2[0]?o1[1] - o2[1]:o2[0]-o1[0]);
            }
        });
        List<int[]> res = new ArrayList<>(people.length);
        for(int[] p : people){
            res.add(p[1], p);
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        new Solution().reconstructQueue(people);
    }
}