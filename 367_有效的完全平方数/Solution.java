class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 0,right = num/2+1;
        long mid = 0;
        while(left<=right){
            mid = left +(right-left)/2;
            if((long)mid*(long)mid==num){
                return true;
            }else if(mid*mid<num){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().isPerfectSquare(808201));
    }
}