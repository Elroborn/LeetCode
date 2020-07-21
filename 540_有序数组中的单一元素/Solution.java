class Solution {
    public int singleNonDuplicate1(int[] nums) {
        int r = 0;
        for(int i: nums){
            r^=i;
        }
        return r;
    }
    public int singleNonDuplicate(int[] nums) {
        
    }
}