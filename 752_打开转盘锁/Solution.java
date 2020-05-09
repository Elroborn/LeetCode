import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public String add1(String s,int i){
        char[] ch = s.toCharArray();
        if(ch[i]=='9'){
            ch[i]='0';
        }else{
            ch[i]++;
        }
        return new String(ch);
    }
    public String minus1(String s,int i){
        char[] ch = s.toCharArray();
        if(ch[i]=='0'){
            ch[i] = '9';
        }else{
            ch[i]--;
        }
        return new String(ch);
    }
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        Set<String> dead = new HashSet<>();
        for(String s:deadends){
            dead.add(s);
        }
        String s = "0000";
        if(!set.contains(s) && !dead.contains(s)){
            set.add(s);
            q.add(s);
        }
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String t = q.poll();
                if(t.equals(target)){
                    return depth;
                }
                for(int m=0;m<4;m++){ //对每一位都进行拨动
                    s = add1(t, m);
                    if(!set.contains(s) && !dead.contains(s)){
                        set.add(s);
                        q.add(s);
                    }
                    s = minus1(t, m);
                    if(!set.contains(s) && !dead.contains(s)){
                        set.add(s);
                        q.add(s);
                    }
                }
            }

            depth++;
        }
        return -1;
    }
    public static void main(String[] args) {
        String[] deadends = {};
        String target = "0009";
        System.out.println(new Solution().openLock(deadends, target));
    }
}