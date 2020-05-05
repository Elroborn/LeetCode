class Solution {
    int step = Integer.MAX_VALUE;
    public int jump(int[] nums) {
       int step = 0;
       int pos = nums.length-1,i=0;
       while(pos>0){
           for(i=0;i<pos;i++){ //找到最小的能直接跳到末尾的元素，贪心
                if(i+nums[i]>=pos){
                    step++;
                    break;
                }
           }
           pos = i; //倒推回去
       }
       return step;
    }

    public int jump2(int[] nums) {
        int[] df = new int[nums.length];
        df[0] = 0;
        for(int i=1;i<nums.length;i++){
            int t = Integer.MAX_VALUE;
            for(int j=i-1;j>=0;j--){
                if(nums[j]>=(i-j)){ //可以跳到
                    t = Math.min(t, df[j]+1);
                }
            }
            df[i] = t;
        }
        
        return df[nums.length-1];

    }

    public int jump1(int[] nums) {
        dfs(nums, 0, 0);
        return step;

    }
    public void dfs(int[]nums,int k,int t){
        if(k>=nums.length-1){
            step = Math.min(t, step);
            return ;
        }
        for(int i=1;i<=nums[k];i++){
            dfs(nums, k+i, t+1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Solution().jump(nums));
    }
}