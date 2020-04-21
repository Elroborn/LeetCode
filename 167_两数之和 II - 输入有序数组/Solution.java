class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];
        int i = 0,j = numbers.length-1;
        while(i<j){
            int s = numbers[i]+numbers[j];
            if(s>target){
                j--;
            }else if(s<target){
                i++;
            }else{
                res[0] = i+1;
                res[1] = j+1;
                return res;
            }
        }
        return res;
    }
    public static void main(String[] args) {
       int[] numbers = {2, 7, 11, 15};
       int target = 9;
       int[]res = new Solution().twoSum(numbers, target);
       System.out.printf("%d %d",res[0],res[1]);
    }
}