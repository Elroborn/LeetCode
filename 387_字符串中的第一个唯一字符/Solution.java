class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[128];
        char[] ss = s.toCharArray();
        for(int i =0;i<ss.length;i++){
            map[ss[i]]++;
        }
        for(int i=0;i<ss.length;i++){
            if(map[ss[i]]==1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(new Solution().firstUniqChar(s));
    }
}