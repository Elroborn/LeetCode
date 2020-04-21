class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
    public static void main(String[] args) {
        int [] nums = {1,2,2,3,4};
        int k = new Solution().removeElement(nums, 2);
        for(int i=0;i<k;i++){
            System.out.println(nums[i]);
        }
    }
}