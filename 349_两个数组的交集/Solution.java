import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer>set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int i:nums1){
            set.add(i);
        }
        for(int i:nums2){
            if(set.contains(i)){
                res.add(i);
                set.remove(i);
            }
        }
        int[] r = new int[res.size()];
        for(int i=0;i<res.size();i++){
            r[i] = (int)res.get(i);
        }
        return r;
    }
    public static void main(String[] args) {
        int[] nums1 =  {4,7,9,7,6,7}, nums2 = {5,0,0,6,1,6,2,2,4};
        int res[] = new Solution().intersection(nums1, nums2);
        for(int i:res){
            System.out.println(i);
        }
    }
}