class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int c = 0,i=a.length()-1,j=b.length()-1;
        while(i>=0 && j>=0){
            int t1 = a.charAt(i)-'0';
            int t2 = b.charAt(j)-'0';
            sb.append((t1+t2+c)%2);
            c = (t1+t2+c)/2;
            i--;
            j--;
        }
        while(i>=0){
            int t1 = a.charAt(i)-'0';
            sb.append((t1+c)%2);
            c = (t1+c)/2;
            i--;
        }
        while(j>=0){
            int t2 = b.charAt(j)-'0';
            sb.append((t2+c)%2);
            c = (t2+c)/2;
            j--;
        }
        if(c>0){
            sb.append(c);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1", "111"));
      
    }
}