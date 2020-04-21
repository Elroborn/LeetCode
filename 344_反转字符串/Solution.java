class Solution {
    public void reverseString(char[] s) {
        int i=0,j = s.length-1;
        while(i<j){
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        char[] s = {'a','b','c'};
        new Solution().reverseString(s);
        for(char c:s){
            System.out.println(c);
        }
    }
}