import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='(' || ch[i]=='[' || ch[i]=='{'){
                stack.push(ch[i]);
            }else{
                char c;
                if(!stack.isEmpty()){
                    c = stack.pop();
                }else{
                    return false;
                }
                if((c=='(' && ch[i]==')') || (c=='[' && ch[i]==']') || (c=='{' && ch[i]=='}')){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("]"));
    }
}