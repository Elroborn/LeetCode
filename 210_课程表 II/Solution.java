import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        for(int[] p:prerequisites){
            inDegree[p[0]]++; //有先选课的标记一下
        }
        Queue<Integer>q = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.offer(i); //度为0即没有先修课的入队
                System.out.println(i);
            }
        }
        int[] res = new int[numCourses];
        int cnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            res[cnt++] = cur;
            // 找到先选课为cur的，然后将其先选课-1
            for(int[]p:prerequisites){
                if(p[1]==cur){
                    inDegree[p[0]]--;//p[0] 的先选课为p[1]
                    if(inDegree[p[0]]==0){
                        q.offer(p[0]);
                    }
                }
            }
        }
        if(cnt==numCourses) return res;
        return new int[0];

    }
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {};
        System.out.println(new Solution().findOrder(numCourses, prerequisites));

    }
}