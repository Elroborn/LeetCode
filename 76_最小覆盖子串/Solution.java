import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> m = new HashMap<>();
        for(int i=0;i<t.length();i++){
            m.put(t.charAt(i), m.getOrDefault(t.charAt(i), 0)+1);
        }
        // 双指针做窗口
        int left = 0,right = 0;
        String res = "";
        int minLen = Integer.MAX_VALUE;
        int cnt = 0;
        while(right<s.length()){
            if(m.containsKey(s.charAt(right))){
                m.put(s.charAt(right), m.get(s.charAt(right))-1);
                if(m.get(s.charAt(right))>=0){
                    cnt++;
                }
            }
            while(cnt==t.length()){ // 说明left -right 窗口内把t包含完了 缩小left
                if(right-left+1 <minLen){
                    minLen = right - left +1;
                    res = s.substring(left,right+1);
                }
                if(m.containsKey(s.charAt(left))){
                    m.put(s.charAt(left), m.get(s.charAt(left))+1);
                    if(m.get(s.charAt(left))>0){
                        cnt--;
                    }
                }
                left++;
            }

            right++;

        }
        return res;
    }
}