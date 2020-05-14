import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        char[] ch = s.toCharArray();

        int i = 0;
        StringBuilder sb ;
        while(i<ch.length){
            sb = new StringBuilder();
            while(i<ch.length && ch[i]>='0' && ch[i]<='9'){
                sb.append(ch[i]);
                i++;
            }
            if(sb.length()>0){
                s1.add(Integer.parseInt(sb.toString()));
                continue;
            }
            if(i<ch.length && ch[i]=='['){
                s2.push(ch[i]+"");
                i++;
                continue;
            }
            sb = new StringBuilder();
            if(i<ch.length && ch[i]==']'){
                int time = s1.pop();
                while(!s2.isEmpty() && !s2.peek().equals("[")){
                    sb.insert(0,s2.pop());
                }
                String st = sb.toString();
                sb = new StringBuilder();
                for(int t=0;t<time;t++){
                    sb.append(st);
                }
                s2.pop(); //'['
                s2.push(sb.toString());
                i++;
                continue;
            }
            if(i<ch.length && ch[i]!=']' && ch[i]!='[' && !(ch[i]>='0' && ch[i]<='9')){
                s2.push(ch[i]+"");
                i++;
                continue;
            }
 
        }
        sb = new StringBuilder();
        while(!s2.isEmpty()){
            sb.insert(0,s2.pop());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
    }
}