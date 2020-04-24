class Solution {
    public int bitSum(int n){
        int res = 0;
        while(n!=0){
            int t = n%10;
            res+=(t*t);
            n = n/10;
        }
        return res;
    }
    public boolean isHappy(int n) {
        int fast = n,slow = n;
        do{
            slow = bitSum(slow);
            fast = bitSum(fast);
            fast = bitSum(fast);
        }while(fast!=slow);
        return slow==1;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(7));
    }
}