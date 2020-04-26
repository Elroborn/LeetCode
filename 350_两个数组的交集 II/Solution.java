import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if(nums2.length<nums1.length){ //这样可以使得map较小
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        for(int i = 0;i<nums1.length;i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }
        for(int i = 0;i<nums2.length;i++){
            Integer val = map.get(nums2[i]);
            if(val!=null && val>0){
                res.add(nums2[i]);
                map.put(nums2[i], val-1);
            }
        }
        int[] r = new int[res.size()];
        for(int i=0;i<res.size();i++){
            r[i] = res.get(i);
        }
        return r;
    }
    public static void main(String[] args) {
        int[] nums1 = {3,1,2}, nums2 = {1,1};
        int[] res = new Solution().intersect(nums1, nums2);
        for(int i:res){
            System.out.println(i);
        }
    }
}