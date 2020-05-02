class Solution {
    public int mySqrt(int x) {
        int left = 0,right = x/2+1;
        int mid = 0;
        long num;
        while(left<=right){
            mid = left +(right-left)/2;
            num = (long)mid*mid;
            if(x<num){
                right = mid-1;
            }else if(x>num){
                left = mid +1;
            }else{
                return mid;
            }
        }
        return right;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(8));
    }
}