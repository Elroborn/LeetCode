import java.util.Stack;
class Solution1 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i=0;i<T.length;i++){
            while(!stack.isEmpty() && T[i]>T[stack.peek()]){
                int tmp = stack.pop();
                res[tmp] = i- tmp;
            }
            stack.push(i);
        }
        return res;

    }
    public static void main(String[] args) {
        int[] T = {73,74,75,71,69,72,76,73};
        int[] res = new Solution1().dailyTemperatures(T);
        for(int t:res){
            System.out.println(t);
        }
    }
}