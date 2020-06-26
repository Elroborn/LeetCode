import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int s = nums[0] + nums[1] + nums[nums.length-1]; // 固定一个，另外两个双指针搜索
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length -1;
            while(left<right){
                int t = nums[i] + nums[left] + nums[right];
                if(Math.abs(s-target)>Math.abs(t-target)){
                    s = t;
                }
                if(t>target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return s;
    }
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(new Solution().threeSumClosest(nums, target));
    }
}