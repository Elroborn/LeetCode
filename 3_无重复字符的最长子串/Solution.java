import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring1(String s) {
        char[] c = s.toCharArray();
        if(c.length==0){
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<c.length;i++){
            HashSet<Character> set = new HashSet<>();
            set.add(c[i]);
            for(int j = i+1;j<c.length;j++){
                if(!set.add(c[j])){
                    break;
                }
            }
            res = Math.max(res, set.size());
        }
        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int res = 0,i=0,j=0;
        HashSet<Character> set = new HashSet<>();
        while(j<c.length){
            if(!set.contains(c[j])){
                set.add(c[j++]);
                res = Math.max(res, set.size());
            }else{
                set.remove(c[i++]);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        String s = "pwckew";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}