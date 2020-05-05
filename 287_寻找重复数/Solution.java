import java.util.HashSet;

class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(new Solution().findDuplicate(nums));
    }
}