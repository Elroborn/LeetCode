class Solution1 {
    public int removeDuplicates(int[] nums) {
        //快慢指针，快的先走探路
        int fast = 0,slow = 0;
        while(fast<nums.length){
            if(nums[fast]!=nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,0,1,1,2};
        int l = new Solution1().removeDuplicates(nums);
        for(int i=0;i<l;i++){
            System.out.println(nums[i]);
        }
    }
}