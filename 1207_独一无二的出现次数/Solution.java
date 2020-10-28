import java.util.HashSet;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-28 09:19:08
 * @FilePath: \leetcode\1207_独一无二的出现次数\Solution.java
 * @LastEditTime: 2020-10-28 09:26:22
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] hash = new int[20001];
        for(int i:arr){
            hash[i+1000]++;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i :hash){
            if(i==0){
                continue;
            }

            if(!set.contains(i)){
                set.add(i);
            }else{
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        new Solution().uniqueOccurrences(arr);
    }
}