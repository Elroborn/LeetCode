import java.util.Arrays;

class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int max_v = arr[arr.length-1];
        int[] prefix = new int[arr.length+1];
        int n = arr.length;
        for(int i=1;i<prefix.length;i++){
            prefix[i] = prefix[i-1] + arr[i-1];
        }
        int res = 0;
        int dis = Integer.MAX_VALUE;
        for(int i=0;i<=max_v;i++){
            int index = Arrays.binarySearch(arr, i);
            int tmp = 0;
            if(index>=0){ // found
                tmp = prefix[index+1] - prefix[0] + (n-index-1)*i;
            }else{ //not found return is -(low+1)
                index = -index -1; // the positon > i
                tmp = prefix[index] - prefix[0] + (n-index)*i;
            }
            if(Math.abs(tmp-target)<dis){
                dis = Math.abs(tmp-target);
                res = i;
            }
        }
        return res;

    }
} 