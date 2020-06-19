class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max_v = Integer.MIN_VALUE;
        for(int i = 0;i<piles.length;i++){
            max_v = Math.max(max_v, piles[i]);
        }
        // for(int k = 1;k<=max_v;k++){ //线性查找 抽出来作为二分
        //     int t = 0;
        //     for(int j=0;j<piles.length;j++){
        //         t+=Math.ceil(piles[j]/(k+0.0));
        //     }
        //     if(t<=H){
        //         return k;
        //     }
        // }
        int left = 1,right = max_v;
        int mid = -1;
        while(left<right){
            mid = (left+right)/2;
            if(check(piles, H, mid)){
               right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    public boolean check(int[] piles,int H,int k){
            int t = 0;
            for(int j=0;j<piles.length;j++){
                // t+=Math.ceil(piles[j]/(k+0.0));
                t = t+ (piles[j]/k + (piles[j]%k>0?1:0));
            }
            return t<=H;
    }
  public static void main(String[] args) {
      int[] piles = {3,6,7,11};
      int H = 8;
      System.out.println(new Solution().minEatingSpeed(piles, H));

  }
}