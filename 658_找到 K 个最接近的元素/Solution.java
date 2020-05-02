import java.util.ArrayList;
import java.util.List;

class Solution {
    // 双指针 删除法
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int remove_size = arr.length - k;
        int i = 0,j = arr.length-1;
        while(remove_size>0){
            if(x - arr[i]>arr[j]-x){
                i++;
            }else{
                j--;
            }
            remove_size--;
        }
        List<Integer> res = new ArrayList<>();
        for(int m=i;m<=j;m++){
            res.add(arr[m]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;
        System.out.println(new Solution().findClosestElements(arr, k, x));
    }
}