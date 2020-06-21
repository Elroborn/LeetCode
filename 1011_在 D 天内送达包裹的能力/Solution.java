class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = weights[0];
        int right = 0;
        for(int i=0;i<weights.length;i++){
            left = Math.max(left, weights[i]);
            right+=weights[i];
        }
        //结果只能是在left-right，可以通过顺序查找，不过会超时。可以二分查找，这里可以用二分查找找左边界(因为要最小)
        int mid = -1;
        while(left<right){
            mid = left + (right-left)/2;
            if(isOk(weights,D,mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    public boolean isOk(int[] weights,int D,int k){ // k是当前最大载重
        int t = 0;
        int cost = 0;
        for(int i=0;i<weights.length;i++){
            t+=weights[i];
            if(t>k){
                cost++;
                t = weights[i];
            }
        }
        if(t!=0){
            cost++;
        }
        return cost<=D;
    }
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        int k = 11;
        System.out.println(new Solution().isOk(weights, D, k));
    }
}