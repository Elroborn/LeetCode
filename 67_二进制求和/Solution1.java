class Solution1 {
    public String addBinary(String a, String b) {
        int c = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        char[] a_ch = a.toCharArray();
        char[] b_ch = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        while(i>=0 && j>=0){
            int a_t = a_ch[i] - '0';
            int b_t = b_ch[j] - '0';
            int t = (a_t+b_t+c)%2;
            sb.append(t+"");
            c = (a_t+b_t+c)/2;
            i--;
            j--;
        }
        while(i>=0){
            int a_t = a_ch[i] - '0';
            int t = (a_t+c)%2;
            sb.append(t+"");
            c = (a_t+c)/2;
            i--;
        }
        while(j>=0){
            int a_t = b_ch[j] - '0';
            int t = (a_t+c)%2;
            sb.append(t+"");
            c = (a_t+c)/2;
            j--;
        }
        if(c>0){
            sb.append(c);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(new Solution1().addBinary(a, b));
    }
}