class Solution {
    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        boolean[][] dp = new boolean[ch.length][ch.length]; //代表是否s[i,j] 是否回文
        String res="";
        for(int l = 0;l<ch.length;l++){
            for(int i=0;i+l<ch.length;i++){ //从长度为0的串，到为n的
                int j = i+l;
                if(l==0){ //肯定回文，就一个字符
                    dp[i][j]  = true;
                }
                else if(l==1){
                    dp[i][j] = (ch[i]==ch[j]); 
                }else{
                    dp[i][j] = (ch[i]==ch[j] && dp[i+1][j-1]);
                }
                if(dp[i][j] && l+1>res.length()){ //比当前结果优
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;

    }
    public static void main(String[] args) {
        String s = "baba";
        System.out.println(new Solution().longestPalindrome(s));
    }
}