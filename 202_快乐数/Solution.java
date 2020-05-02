class Solution {
    public int bitSum(int num){
        int s = 0;
        while(num>0){
            int t = num%10;
            s+=(t*t);
            num/=10;
        }
        return s;
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
    public boolean isHappy1(int n) {
        int low = bitSum(n);
        int fast = bitSum(n);
        fast = bitSum(fast);
        while(low!=fast){
            low = bitSum(low);
            fast = bitSum(fast);
            fast = bitSum(fast);
        }
        return low==1;
        
    }
    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(7));
    }
}