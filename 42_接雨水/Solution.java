class Solution {
    public int trap1(int[] height) {
        //对于第i个位置储水为 min(max(0-i),max(i+1,end)) -height[i]
        int res = 0;
        for(int i=0;i<height.length;i++){
            int t = Math.min(getMax(height,0,i), getMax(height,i,height.length-1)) - height[i];
            res+=(t>0?t:0);
        }
        return res;

    }
    public int getMax(int[] height,int i,int j){
        int t = height[i];
        for(int k=i;k<=j;k++){
            t = Math.max(t, height[k]);
        }
        return t;

    }
    public int trap(int[] height) {
        //为了避免每次都算到i的最高，可以先存储下来 数组lm[i] 代表左边到i的最高
        //rm[i] 代表右边到i-end最大
        if(height.length==0){
            return 0;
        }
        int[] lm = new int[height.length];
        lm[0] = height[0];
        for(int i=1;i<height.length;i++){
            lm[i] = Math.max(height[i], lm[i-1]);
        }
        int[] rm = new int[height.length];
        rm[height.length-1] = height[height.length-1];
        for(int i= height.length-2;i>=0;i--){
            rm[i] = Math.max(height[i], rm[i+1]);
        }
        int res = 0;
        for(int i=0;i<height.length;i++){
            int t = Math.min(lm[i],rm[i]) - height[i];
            res+=(t>0?t:0);
        }
        return res;

    }
 

}