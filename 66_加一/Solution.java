class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1;
        int res[] = new int[digits.length];
        for(int i = digits.length-1;i>=0;i--){
            res[i] = (digits[i]+c)%10;
            c =  (digits[i]+c)/10;
        }
        if(c>0){
            res = new int[res.length+1]; // 说明99这种情况，则首位为1，其他未0
            res[0] = c;
            return res;
        }else{
            return res;
        }
    }
    public static void main(String[] args) {
        int [] digits = {9,9,9};
        int res[] = new Solution().plusOne(digits);
        for(int n:res){
            System.out.println(n);
        }
    }
}