import java.util.HashMap;

class Solution {
    public int singleNumber1(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        for(int i:nums){
            if(map.get(i)==1){
                return i;
            }
        }
        return -1;
    }
    public int singleNumber(int[] nums) {
        // a^a = 0 ,0^b = b
        int res = 0;
        for(int i:nums){
            res^=i;
        }
        
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(new Solution().singleNumber(nums));
    }
}