import java.util.List;
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int res = Integer.MAX_VALUE;
        for(int i = 1;i<triangle.size();i++){
            for(int j = 0;j<triangle.get(i).size();j++){
                if(j==0){
                    triangle.get(i).set(j, triangle.get(i).get(j)+triangle.get(i-1).get(j));
                    continue;
                }
                if(j== triangle.get(i).size()-1){
                    triangle.get(i).set(j, triangle.get(i).get(j)+triangle.get(i-1).get(j-1));
                    continue;
                }
                int v = Math.min(triangle.get(i).get(j)+triangle.get(i-1).get(j), triangle.get(i).get(j)+triangle.get(i-1).get(j-1));
                triangle.get(i).set(j,v);
            }
        }
        for(int j = 0;j<triangle.get(triangle.size()-1).size();j++){
            res = Math.min(res, triangle.get(triangle.size()-1).get(j));
        }
        return res;

    }
}