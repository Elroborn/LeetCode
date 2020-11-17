/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-13 10:23:43
 * @FilePath: \leetcode\406_根据身高重建队列\Solution.java
 * @LastEditTime: 2020-11-16 14:59:15
 */ 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
class Solution {
    // 心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1,int[]o2){
                return (o1[0]==o2[0]?o1[1] - o2[1]:o2[0]-o1[0]); //先按身高降序
            }
        });
        List<int[]> res = new ArrayList<>(people.length);
        for(int[] p : people){
            res.add(p[1], p); // 然后按个数插入
            // System.out.println(p[0]);
            System.out.printf("%d %d\n",p[0],p[1]);
        }
        System.out.println();
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        // int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        // int[][] t = new Solution().reconstructQueue(people);
        // for(int [] i:t){
        //     System.out.printf("%d %d\n",i[0],i[1]);
        // }
        int[][] t = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        ArrayList<int[]> r = new ArrayList<>();
        r.add(1, t[0]);
        System.out.println(r.toString());
    }
}