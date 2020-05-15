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

    }
}