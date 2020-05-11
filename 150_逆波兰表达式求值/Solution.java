import java.util.Stack;

class Solution {
    public int operate(int num1,int num2,String op){
        if(op.equals("+")){
            return num1+num2;
        }
        if(op.equals("-")){
            return num1-num2;
        }
        if(op.equals("*")){
            return num1*num2;
        }
        if(op.equals("/")){
            return num1/num2;
        }
        return Integer.MAX_VALUE;
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int operate_num = operate(num1, num2, tokens[i]);
                stack.push(operate_num);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new Solution().evalRPN(tokens));
    }
}