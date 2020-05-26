import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public boolean isDigit(char c){
        if(c>='0' && c<='9'){
            return true;
        }else{
            return false;
        }
    }
    //TODO 等待后续实现 空格和括号 这个sign = ‘+ num = 0 做初始化觉得是一个很巧妙的操作
    public int calculate(String s) {
        char[] ch = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for(char c:ch){
            list.add(c);
        }
        return helper(list);
   
    }
    public int helper(List<Character> list) { // 因为算完括号 需要更新位置，而用String不方便，直接List是引用，所以直接走一个删一个
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+'; // 可以规避 开头就是-号，避免判断，假如前面有了+0
        while (list.size() > 0) {
            char ch = list.remove(0); // 用一个删一个，方便括号的递归

            if (isDigit(ch)) {
                num = num * 10 + (ch - '0'); // 防止溢出，先减后加
            }
            if (ch == '(') {
                num = helper(list);
            }
            if ((!isDigit(ch) && ch != ' ') || list.size() == 0) {
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
                sign = ch;
                num = 0;
            }
            if(ch==')'){
                break;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
    public int fun(String s){
        //会出现i不好更新，所以用上面的方法
        char[] ch = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+'; // 可以规避 开头就是-号，避免判断，假如前面有了+0
        for(int i=0;i<ch.length;i++){
            if(isDigit(ch[i])){
                num = num*10 + (ch[i]-'0'); // 防止溢出，先减后加
            }
            if(ch[i]=='('){
                num = calculate(s.substring(i+1));
            }
            if((!isDigit(ch[i]) && ch[i]!=' ')|| i==ch.length-1){
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
            if(ch[i]==')'){
                break;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "(3+5)*6";
        System.out.println(new Solution().calculate(s));
    }
}