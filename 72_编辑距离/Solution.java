class Solution {
    public int minDistance1(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        return dp(s1.length-1, s2.length-1, s1, s2);
    }
    public int dp(int i,int j,char[] s1,char[] s2){
        if(i==-1){
            return j+1;//边界条件，一个到头，则距离是另外一个长度
        }
        if(j==-1){
            return i+1;//边界条件，一个到头，则距离是另外一个长度
        }
        if(s1[i]==s2[j]){
            return dp(i-1, j-1, s1, s2);
        }else{
            //插入，删除和替换挑最小的一个
            return Math.min(dp(i,j-1,s1,s2)+1, Math.min(dp(i-1,j,s1,s2)+1, dp(i-1,j-1,s1,s2)+1));
        }
    }
    public int minDistance(String word1, String word2) {
        // 其和上面逻辑类似，只是数组不能从-1开始，所以偏移一个位 表的含义如下，注意多了一个空串，空串就是base case
        //   “”  a  p  p  l  e
        //""
        //r
        //a
        //p
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int m = s1.length;
        int n = s2.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            dp[i][0] = i;
        }
        for(int j=1;j<=n;j++){
            dp[0][j] = j;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]+1));
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String word1 = "";
        String word2 = "a";
        System.out.println(new Solution().minDistance(word1, word2));
    }
}