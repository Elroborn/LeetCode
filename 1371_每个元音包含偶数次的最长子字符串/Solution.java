import java.util.HashMap;
import java.util.Arrays;
class Solution {
    public int findTheLongestSubstring1(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }
    public boolean check(int[][] pre,int i,int j){
        for(int k=0;k<5;k++){
            if((pre[i+1][k]-pre[j][k])%2!=0){
                return false;
            }
        }
        return true;
    }
    public int findTheLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int res = 0;
        int[][] pre = new int[ch.length+1][5];
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='a'){
                pre[i+1][0] = pre[i][0]++;
            }else{
                pre[i+1][0] = pre[i][0];
            }
            if(ch[i]=='e'){
                pre[i+1][1] = pre[i][1]++;
            }else{
                pre[i+1][1] = pre[i][1];
            }
            if(ch[i]=='i'){
                pre[i+1][2] = pre[i][2]++;
            }else{
                pre[i+1][2] = pre[i][2];
            }
            if(ch[i]=='o'){
                pre[i+1][3] = pre[i][3]++;
            }else{
                pre[i+1][3] = pre[i][3];
            }
            if(ch[i]=='u'){
                pre[i+1][4] = pre[i][4]++;
            }else{
                pre[i+1][4] = pre[i][4];
            }
        }
        for(int i=0;i<pre.length;i++){
            for(int j=0;j<pre[i].length;j++){
                System.out.printf("%d ",pre[i][j]);
            }
            System.out.println();
        }
        for(int i=0;i<ch.length;i++){
            for(int j=0;j<=i;j++){
                if(check(pre, i, j)){
                    res = Math.max(res, i-j+1);
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "leetcodeisgreat";
        System.out.println(new Solution().findTheLongestSubstring(s));
    }
}
