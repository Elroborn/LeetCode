import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<Integer> getRow1(int rowIndex) {
        List<Integer>pre = new ArrayList<Integer>();
        List<Integer>res = new ArrayList<Integer>();
        pre.add(1);
        res = new ArrayList<Integer>(pre);
        for(int i=1;i<=rowIndex;i++){
            res.clear();
            res.add(1);
            for(int j=1;j<i;j++){
                res.add(pre.get(j)+pre.get(j-1));
            }
            res.add(1);
            pre = new ArrayList<Integer>(res);
        }
        return res;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer>res = new ArrayList<Integer>();
        res.add(1);
        for(int i=1;i<=rowIndex;i++){
            int pre = res.get(0);
            for(int j=1;j<i;j++){
                int t = res.get(j);
                res.set(j, pre+t);
                pre = t;
            }
            res.add(1);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().getRow(3));
    }
}