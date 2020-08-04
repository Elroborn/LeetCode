import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-04 09:57:18
 * @FilePath: \leetcode\207_课程表\Solution.java
 * @LastEditTime: 2020-08-04 11:40:09
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 拓扑排序，先把所有入度为0入队，然后把其对应的出度-1，如果入度为0就代表没有前导课
        // 先构造拓扑结构，用拉链法
        List<List<Integer>> list = new ArrayList<>(); // 每一行代表这个课程是哪些课的先导课 比如第1行有[0,2]代表课程1是0,2 的先导课，然后如果课程1 的inedge为0说明1可以学，也就说明0和2的inedge可以减少一门
        int[] inedges = new int[numCourses] ;// 每个课程的入度，也就是有几个先导课
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>()); //初始化
        }
        for(int[] p:prerequisites){
            list.get(p[1]).add(p[0]);
            ++inedges[p[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        int visited = 0;
        for(int i=0;i<inedges.length;i++){
            if(inedges[i]==0){ //说明没有先导课，可以直接学
                 queue.add(i);
                 visited++;
            }
        }
        while(!queue.isEmpty()){
            int t = queue.poll();
            // 看下课程t都是谁的先导课(x)，因为t已经学完了，所以相当于这些x的先导课可以-1了
            for(int i:list.get(t)){
                --inedges[i];
                if(inedges[i]==0){ // 说明这个课程的先导课都完了，这个课程也可以学习了
                     queue.add(i);
                     visited++;
                }
            }
        }
        return visited==numCourses;
    }
    public static void main(String[] args) {

        int numCourses = 3;
        int[][] prerequisites = {{1,0},{0,2},{2,1}};
        // int numCourses = 2;
        // int[][] prerequisites = {{1,0}};
        System.out.println(new Solution().canFinish(numCourses, prerequisites));
    }
}