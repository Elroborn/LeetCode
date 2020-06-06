import java.util.HashMap;

class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n, 1);
        }
        for(int i=0;i<nums.length;i++){
            int start = nums[i];
            int end = start;
            if(map.containsKey(start-1)){
                continue; //因为start -1 -end肯定比 start -end 更优，所以就跳出不用看start -end了
            }
            while(map.containsKey(end)){
                end++;
            }
            res = Math.max(res, end-start);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new Solution().longestConsecutive(nums));
    }
}