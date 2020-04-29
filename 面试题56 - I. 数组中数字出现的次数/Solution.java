class Solution {
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        int ab = 0;
        for(int n:nums){
            ab^=n; // ab 就是两个不同数字a b的异或值
        }
        // 开始分组，不同的数字要分到不同组里面，因为ab是a^b的值，所以如果ab为1的位值是1，代表这个位置上a和b是不同的
        int mask = 1;
        while((ab&mask)==0){
            mask<<=1;
        }
        for(int n:nums){
            if((n&mask)==0){ //这个是一组
                res[0]^=n;
            }else{
                res[1]^=n;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[]nums = {1,2,10,4,1,4,3,3};
        int[] res = new Solution().singleNumbers(nums);
        for(int n:res){
            System.out.println(n);
        }
    }
}