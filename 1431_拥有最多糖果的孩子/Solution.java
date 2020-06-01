import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int cur_max = -1;
        for(int n:candies){
            cur_max = Math.max(cur_max, n);
        }
        List<Boolean> res = new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=cur_max){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;

    }
}