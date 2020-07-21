/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-05-01 09:14:30
 * @FilePath: \leetcode\278_第一个错误的版本\Solution.java
 * @LastEditTime: 2020-07-21 14:17:56
 */ 
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
class VersionControl{
        boolean[] nums= {false,false,false,false,false,true};
        public boolean isBadVersion(int version){
            return nums[version];
        }
}
public class Solution extends VersionControl {

    // public int firstBadVersion1(int n) {
    //     int left = 1,right = n;
    //     int mid = 0;
    //     while(left<right){
    //         mid = left +(right-left)/2;
    //         if(isBadVersion(mid)==false && isBadVersion(mid+1)==true){
    //             return mid+1;
    //         }else if(isBadVersion(mid)==false && isBadVersion(mid+1)==false){
    //             left = mid+1;
    //         }else{
    //             right = mid;
    //         }
    //     }
    //     return left;
    // }
    public int firstBadVersion(int n) {
        // 其实就是找左边界
        int left = 1, right = n;
        int mid = 0;
        while(left<right){
            mid = left + (right - left)/2;
            if(isBadVersion(mid)){
                right = mid; // 说明在[l,m] 之间，所以right = m 而不是m - 1； 而因为是m所以要在while里面用<
            }else{
                left = mid + 1;
            }
        }
        return left;
        
    }
    public static void main(String[] args) {
        System.out.println(new Solution().firstBadVersion(5));
    }
}