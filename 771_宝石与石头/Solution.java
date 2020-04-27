class Solution {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        int[] baoshi = new int[128];
        for(char c :J.toCharArray()){
            baoshi[c] ++;
        }
        for(char c:S.toCharArray()){
            if(baoshi[c]>0){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        System.out.println(new Solution().numJewelsInStones(J, S));
    }
}