import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = {0,0};
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                return res;
            }else{
                map.put(nums[i], i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,5};
        int[] res = new Solution().twoSum(nums, 18);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}