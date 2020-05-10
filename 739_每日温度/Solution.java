import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<T.length;i++){
            while(!s.isEmpty() && T[i]>T[s.peek()]){
                int t = s.pop();
                res[t] = i-t;
            }
            s.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] T = {73,74,75,71,69,72,76,73};
        int[] res = new Solution().dailyTemperatures(T);
        for(int t:res){
            System.out.println(t);
        }
    }
}