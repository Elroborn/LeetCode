class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int i = 0;
        int j = 0;
        while(j<nums.length){
            while(j<nums.length && nums[j]==nums[i]){
                j++;
            }
            if(j<nums.length){
                i++;
                nums[i] = nums[j];
            }
            
        }
        return i+1;
    }
    public static void main(String[] args) {
        int nums[] = {};
        int l = new Solution().removeDuplicates(nums);
        for(int j=0;j<l;j++){
            System.out.println(nums[j]);
        }
    }
}