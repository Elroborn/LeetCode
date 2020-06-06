class Solution {
    public int sumNums(int n) {
        boolean a = n>0 && (n+=sumNums(n-1))>0; // 因为不能够用for，所以考虑递归； 因为不能用if，考虑短路原则
        return n;
    }
    public static void main(String[] args) {
        new Solution().sumNums(3);
    }
}