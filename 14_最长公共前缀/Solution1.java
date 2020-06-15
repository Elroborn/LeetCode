import java.util.Arrays;
import java.util.Comparator;

class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String o1, String o2){
                return o1.length() - o2.length();
            }
        });
        String r = "";
        for(int l=1;l<=strs[0].length();l++){
            String pre = strs[0].substring(0, 0+l);
            boolean flag = true;
            for(int i=1;i<strs.length;i++){
                if(!strs[i].startsWith(pre)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                r = pre;
            }else{
                break;
            }
        }

        return r;
    }
    public static void main(String[] args) {
        String[] strs = {""};
        System.out.println(new Solution1().longestCommonPrefix(strs));
    }
}