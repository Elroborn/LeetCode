import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-10 09:59:49
 * @FilePath: \leetcode\696_计数二进制子串\Solution.java
 * @LastEditTime: 2020-08-10 10:16:19
 */
// https://leetcode-cn.com/problems/count-binary-substrings/solution/ji-shu-er-jin-zhi-zi-chuan-by-leetcode-solution/
class Solution {
    public int countBinarySubstrings(String s) {
        if(s.length()<2){
            return 0;
        }
        int[] count = new int[s.length()];
        int index = 0;
        int pre = s.charAt(0)-'0';
        int curr = s.charAt(0) - '0';
        count[index] ++;
        for(int i = 1;i<s.length();i++){
            curr = s.charAt(i) - '0';
            if(curr==pre){
                count[index]++;
            }else{
                pre = curr;
                index++;
                count[index]++;
            }
        }
        int res = 0;
        for(int i=0 ;i<count.length-1;i++){
            res += Math.min(count[i], count[i+1]);
        }
        return res;
    }
}