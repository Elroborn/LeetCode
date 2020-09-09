import java.util.Arrays;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-09 10:48:03
 * @FilePath: \leetcode\剑指 Offer 40. 最小的k个数\Solution.java
 * @LastEditTime: 2020-09-09 11:05:53
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return quick_sort(arr, 0, arr.length-1, k-1); //注意这里是k-1 因为对于{1,2,3}如果选top 3，那么k = 3在Arrays会溢出
    }
    public int[] quick_sort(int[] arr,int left,int right,int k){
        int p = partion(arr, left, right);
        if(p==k){ // 说明k之前的都是小于arr[k] 也就是topk
            return Arrays.copyOf(arr, k+1);
        }else{
            return p>k?quick_sort(arr, left,p-1,k):quick_sort(arr, p+1, right, k);
        }
    }
    public int partion(int[] arr,int left,int right){
        int t = arr[left];
        int i = left,j = right;
        while(i<j){
            while(i<j && arr[j]>=t){
                j--;
            }
            arr[i] = arr[j];
            while(i<j && arr[i]<=t){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = t;
        return i;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,2,1};
        int k = 4;
        for(int n:new Solution().getLeastNumbers(arr, k)){
            System.out.println(n);
        }
    }
}