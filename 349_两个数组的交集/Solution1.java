import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-11-02 09:58:26
 * @FilePath: \leetcode\349_两个数组的交集\Solution1.java
 * @LastEditTime: 2020-11-02 10:08:31
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length + nums2.length];
        int i = 0,j = 0,index = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                if(index==0 || nums1[i]!=res[index-1]){
                    res[index++] = nums1[i];
                }
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}