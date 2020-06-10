class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int p = 1 ;
        int q = 1;
        int r = q;
        for(int i=1;i<s.length();i++){
            r = 0;
            r+=q;
            String pre = s.substring(i-1,i+1);// [i-1,i]
            if(pre.compareTo("25")<=0 && pre.compareTo("10")>=0){
                r+=p;
            }
        
            p = q;
            q = r;
        }
        return r;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(12258));
    }
}