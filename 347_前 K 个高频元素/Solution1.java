import java.util.ArrayList;
import java.util.HashMap;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-07 10:07:11
 * @FilePath: \leetcode\347_前 K 个高频元素\Solution1.java
 * @LastEditTime: 2020-07-07 10:26:35
 */ 
class Solution1 {
    //找一个桶 存储同频率的数字的list 这样从右边往左就是top k的频率
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>(); // 首先将所有数字频率统计一下
        for(int n:nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        // 然后将频率放入 频率最大为数组长度（既全部都是同一个数字）
        ArrayList<Integer>[] buck = new ArrayList[nums.length+1];
        for(Integer key: map.keySet()){
            Integer fre = map.get(key);
            if(buck[fre]==null){
                buck[fre] = new ArrayList<>();
                buck[fre].add(key);
            }else{
                buck[fre].add(key);
            }
        }
        int[] res = new int[k];
        int j = 0;
        for(int i = nums.length;i>=0;i--){
            if(buck[i]!=null){
                for(int t:buck[i]){
                    res[j++] = t;
                    if(j==k){
                        return res;
                    }
                }
            }
        }
        return res;
    }
}