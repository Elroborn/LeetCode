import java.util.Stack;

class Solution {
    public boolean isDigit(char c){
        if(c>='0' && c<='9'){
            return true;
        }else{
            return false;
        }
    }
    public int calculate(String s) {
        char[] ch = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+'; // 可以规避 开头就是-号，避免判断，假如前面有了+0
        for(int i=0;i<ch.length;i++){
            if(isDigit(ch[i])){
                num = num*10 + (ch[i]-'0'); // 防止溢出，先减后加
            }
            if(!isDigit(ch[i]) || i==ch.length-1){
                if(sign=='+'){
                    stack.push(num);
                }else if(sign=='-'){
                    stack.push(-num);
                }else if(sign=='*'){
                    int t = stack.pop();
                    stack.push(t*num);
                }else if(sign=='/'){
                    int t = stack.pop();
                    stack.push(t/num);
                }
                sign = ch[i];
                num = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "3+5*6";
        System.out.println(new Solution().calculate(s));
    }
}