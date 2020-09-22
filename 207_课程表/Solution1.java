import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-22 12:32:24
 * @FilePath: \leetcode\207_课程表\Solution1.java
 * @LastEditTime: 2020-09-22 12:54:39
 */
class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] nums = new int[numCourses];
        List<List<Integer>> map = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            map.add(new ArrayList<>()); //初始化
        }
        for(int[] pre:prerequisites){
            nums[pre[0]]++;
            map.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int vis =0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0){
                queue.add(i);
                vis++;
            }
        }
        while(!queue.isEmpty()){
            int t = queue.poll();
            for(int i:map.get(t)){
                nums[i]--;
                if(nums[i]==0){
                    queue.add(i);
                    vis++;
                }
            }
        }
        return vis==numCourses;

    }
    public static void main(String[] args) {
        
        // int numCourses = 3;
        // int[][] prerequisites = {{1,0},{0,2},{2,1}};
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(new Solution1().canFinish(numCourses, prerequisites));
    }
}