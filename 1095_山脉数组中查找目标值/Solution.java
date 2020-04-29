import java.util.ArrayList;
import java.util.List;
// This is MountainArray's API interface.
 // You should not implement it, or speculate about its implementation
interface MountainArray {
      public int get(int index);
      public int length();
 }
 class MountainArrImp implements MountainArray{
     List<Integer> list = new ArrayList<>();
     public MountainArrImp(int[] nums){
         for(int i:nums){
             list.add(i);
         }
     }
     public int get(int index){
         return list.get(index);

     }
     public int length(){
         return list.size();
     }
 }
class Solution {

    public int binary_search(MountainArray mountainArr,int left,int right,int target,int flag){
        target = flag *target;
        while(left<=right){
            int mid = (left+right) /2;
            int mid_v = flag*mountainArr.get(mid);
            if(mid_v==target){
                return mid;
            }else if(target<mid_v){
                right = mid -1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
    // 不能照搬33 因为左右会有重复区间，比如 1 5 2 找2  第一轮到左边且2是在1-5之间，但最后找不到
    // 33 题是两个区间没有重复，可以直接
    // 本题采用先找峰值，在左右做二分，而峰值也通过二分找
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0,right = mountainArr.length()-1;
        while(left<right){
            int mid = (left + right) /2;
            if(mountainArr.get(mid+1)>mountainArr.get(mid)){
                left = mid+1; //mid+1有可能是顶峰
            }else{ //因为没有等于，所以else就是<
                right = mid; //mid有可能是顶峰
            }
        }
        int peek = left;
        int res = binary_search(mountainArr, 0, peek, target,1);
        if(res!=-1){
            return res;
        }
        res = binary_search(mountainArr, peek+1, mountainArr.length()-1, target,-1);
        if(res!=-1){
            return res;
        }else{
            return -1;
        }
        
    }
    public static void main(String[] args) {
        int[] nums = {0,5,3,1};
        MountainArrImp mountainArr = new MountainArrImp(nums);
        System.out.println(new Solution().findInMountainArray(1, mountainArr));
    }
}