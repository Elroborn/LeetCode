class Solution {
    public boolean isPalindrome(int x) {
        char[] ch = String.valueOf(x).toCharArray();
        int i =0,j = ch.length-1;
        while(i<j){
            if(ch[i]==ch[j]){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;

    }
}