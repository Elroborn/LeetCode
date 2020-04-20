import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows<=0){
            return res;
        }
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for(int j=1;j<=i;j++){
                if(j==i){
                    tmp.add(1);
                }else{
                    tmp.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
            res.add(tmp);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().generate(4));
    }
}