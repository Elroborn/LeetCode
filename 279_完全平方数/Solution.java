import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
class Solution {
    public int numSquares(int n) {
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
    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(1));
    }
}