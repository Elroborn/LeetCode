class Solution {
    public String reverseWords(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i<s.length()){
            StringBuilder t = new StringBuilder(); 
            while(i<s.length() && s.charAt(i)!=' '){
                t.append(s.charAt(i));
                i++;
            }
            if(t.length()>0){
                sb.append(t.reverse());
            }
            while(i<s.length() && s.charAt(i)==' '){
                i++;
            }
            if(i<s.length()){
                sb.append(' ');
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "Let's     take LeetCode contest  ";
        System.out.println(new Solution().reverseWords(s)+"||");
    }
}