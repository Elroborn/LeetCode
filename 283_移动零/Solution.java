class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while(i<nums.length && nums[i]!=0){
            i++;
        }
        j = i; // i代表不为0的边界，也就是第一个0，j代表找到一个不为0的赋值到i上面
        while(j<nums.length){
            while(j<nums.length && nums[j]==0){
                j++;
            }
            while(i<nums.length && nums[i]!=0){
                i++;
            }
            if(j<nums.length){
                nums[i] = nums[j];
                nums[j] = 0;
            }

        }

    }
    public static void main(String[] args) {
        int nums[] = {1,0,1,0,3,2};
        new Solution().moveZeroes(nums);
        for(int n:nums){
            System.out.println(n);;
        }
    }
}