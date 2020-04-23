import java.util.HashSet;
import java.util.Set;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> ss = new HashSet<>();
        for(int i :nums){
            if(!ss.add(i)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new Solution().containsDuplicate(nums));
    }
}