import java.util.Arrays;
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int t = 0;
        for(int i=0;i<nums.length;i+=2){
            System.out.println(i);
            t+=Math.min(nums[i], nums[i+1]);
        }
        return t;
    }
    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        System.out.println(new Solution().arrayPairSum(nums));

    }
}