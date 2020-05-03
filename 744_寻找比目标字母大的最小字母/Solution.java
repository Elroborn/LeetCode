class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0,right = letters.length-1;
        int mid = 0;
        while(left<=right){
            mid = left + (right-left)/2;
            if(letters[mid]==target){
                left = mid+1;
            }else if(letters[mid]<target){
                left = mid +1;
            }else{
                right = mid-1;
            }
        }
        // 其实就是找到待插入的位置
        return letters[left%letters.length];
    }
    public static void main(String[] args) {
        char[] letters= {'c','f','g'};
        char target = 'a';
        System.out.println(new Solution().nextGreatestLetter(letters, target));
    }
}