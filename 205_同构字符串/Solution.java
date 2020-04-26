class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[128]; //128表示ascaii，模拟map
        int[] map2 = new int[128]; //128表示ascaii，模拟map
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        if(chars1.length !=chars2.length){
            return false;
        }
        for(int i=0;i<chars1.length;i++){
            if(map1[chars1[i]]==0 && map2[chars2[i]]==0){
                map1[chars1[i]]  = chars2[i];
                map2[chars2[i]]  = chars1[i];
            }else if(map1[chars1[i]] ==chars2[i] && map2[chars2[i]]==chars1[i]){
                continue;
            }else{
                return false;
            }
        }
        return true;
   
    }
    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        System.out.println(new Solution().isIsomorphic(s, t));
    }
}