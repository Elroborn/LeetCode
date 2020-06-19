class Solution {
    public boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i= 0;i<ch.length;i++){
            if((ch[i]>='0' && ch[i]<='9') || (ch[i]>='a' && ch[i]<='z') || (ch[i]>='A' && ch[i]<='Z')){
                sb.append(ch[i]);
            }
        }
        ch = sb.toString().toCharArray();
        int i = 0,j = ch.length-1;
        while(i<j){
            if(isEqual(ch[i], ch[j])){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean isEqual(char c1,char c2){ //统一转化为小写进行比较
        if(c1>='A' && c1<='Z'){
            c1 +=32;
        }
        if(c2>='A' && c2<='Z'){
            c2 +=32;
        }
        return c1==c2;
    }
    public static void main(String[] args) {
        char a = 'A';
        // a= a+32;
        a+=32;
        System.out.println(a);
    }
}