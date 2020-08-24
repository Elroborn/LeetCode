/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-05-08 10:39:41
 * @FilePath: \leetcode\279_完全平方数\Solution.java
 * @LastEditTime: 2020-08-24 11:26:47
 */ 

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
class Solution {
    public int numSquares1(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int depth = 0;
        q.add(n);
        set.add(n);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int t = q.poll();
                if(t==0){
                    return depth;
                }
                for(int j =1;j*j<=t;j++){
                    if(!set.contains(t-j*j)){
                        set.add(t-j*j);
                        q.add(t-j*j);
                    }
                    
                }
            }
            depth++;
        }
        return -1;

    }
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(n);
        set.add(n);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0;k<size;k++){
                int t = queue.poll();
                if(t==0){
                    return depth;
                }
                for(int i = 1;i*i<=t;i++){
                    if(!set.contains(t-i*i)){
                        queue.add(t-i*i);
                        set.add(t-i*i);
                    }
                }
            }
   
            depth++;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(1));
    }
}