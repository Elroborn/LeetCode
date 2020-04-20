import java.util.ArrayList;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if(strs.length==0){
            return res;
        }
        int min_l = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            min_l = Math.min(strs[i].length(), min_l);
        }
        for(int i=min_l;i>=0;i--){
            String comm = strs[0].substring(0,i);
            int j = 0;
            for(j=0;j<strs.length;j++){
                if(!comm.equals(strs[j].subSequence(0, i))){
                    break;
                }
            }
            if(j==strs.length){ //所有都等
                return comm;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String[] strs = {"a"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}