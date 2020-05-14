class Solution1 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int n:nums){
            res = res^n;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(new Solution1().singleNumber(nums));
    }
}