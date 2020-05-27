import java.util.HashMap;

class Solution {
    public int subarraySum1(int[] nums, int k) {
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    //前缀和结合hashmap 未做
    public int subarraySum(int[] nums,int k){
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        for(int i=0;i<nums.length;i++){
            preSum[i+1] = preSum[i] + nums[i];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i=0;i<=nums.length;i++){
            int p = preSum[i] -k;
            if(map.containsKey(p)){
                cnt+=map.get(p);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0)+1);
        }
        // for(int key:map.keySet()){
        //     System.out.println(key+" "+map.get(key));
        // }
        return cnt;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(new Solution().subarraySum(nums, k));
    }
}