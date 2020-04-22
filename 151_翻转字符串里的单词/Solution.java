import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> sp = split(s);
        if(sp.size()==0){
            return "";
        }
        for(int i=sp.size()-1;i>0;i--){
            sb.append(sp.get(i)+" ");
        }
        sb.append(sp.get(0));
        return sb.toString();

    }
    
    public List<String> split(String s){
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<s.length()){
            StringBuilder sb = new StringBuilder();
            while(i<s.length() && s.charAt(i)!=' '){
                sb.append(s.charAt(i));
                i++;
            }
            if(sb.length()>0){
                res.add(sb.toString());
            }
            while(i<s.length() && s.charAt(i)==' '){
                i++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "  ";
        System.out.println(new Solution().reverseWords(s));
    }
}