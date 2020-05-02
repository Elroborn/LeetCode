/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
      class VersionControl{
        boolean[] nums= {false,false,false,false,false,true};
        public boolean isBadVersion(int version){
            return nums[version];
        }
    }
    public class Solution extends VersionControl {
    
        public int firstBadVersion(int n) {
            int left = 1,right = n;
            int mid = 0;
            while(left<right){
                mid = left +(right-left)/2;
                if(isBadVersion(mid)==false && isBadVersion(mid+1)==true){
                    return mid+1;
                }else if(isBadVersion(mid)==false && isBadVersion(mid+1)==false){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
            return left;
        }
        public static void main(String[] args) {
            System.out.println(new Solution().firstBadVersion(5));
        }
    }