import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> pancakeSort(int[] A) {
        helper(A, A.length);
        return res;
    }
    public void helper(int[] A,int n){
        if(n==1){
            return ; //只有一个饼，不用翻转
        }
        // 策略是先找到最大的比如第i，然后先把0-i翻转，再前n个翻转，这样最大的就到最后了，问题缩小为n-1
        int maxIndex = 0;
        for(int i=0;i<n;i++){
            if(A[i]>A[maxIndex]){
                maxIndex = i;
            }
        }
        // 先翻转0-maxIndex 把最大到首部
        reverse(A, 0, maxIndex);
        res.add(maxIndex+1);
        // 再翻转0-n 把最大到尾部
        reverse(A, 0, n-1);
        res.add(n);
        helper(A, n-1);


    }
    public void reverse(int[] A,int i,int j){
        while(i<j){
            A[i]^=A[j];
            A[j]^=A[i];
            A[i]^=A[j];
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int[] A = {3,2,4,1};
        new Solution().pancakeSort(A);
        for(int a:A){
            System.out.println(a);
        }
    }
}