class Solution {
    // 固定高，两边扩散
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for(int mid = 0;mid<heights.length;mid++){
            int height = heights[mid];
            int left = mid,right = mid;
            while(left-1>=0 && heights[left-1]>=height){ // 注意是看left-1符不符合，如果用的是left，则最后left是不符合的，计算式面积要用left+1
                left--;
            }
            while(right+1<heights.length && heights[right+1]>=height){
                right++;
            }
            res = Math.max(res, height*(right-left+1));
        }
        return res;

    }
}