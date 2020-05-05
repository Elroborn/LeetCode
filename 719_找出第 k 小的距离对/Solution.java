import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;;
class Pair{
    int p1;
    int p2;
    public Pair(int t1,int t2){
        p1 = t1;
        p2 = t2;
    }
    public String toString(){
        return p1+" "+p2;
    }
}
class Solution {
    // 超时
    public int smallestDistancePair1(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair o1, Pair o2) {
                int d1 = nums[o1.p2] - nums[o1.p1];
                int d2 = nums[o2.p2] - nums[o2.p1];
                return d1 - d2;
            }
        });
        for(int i=0;i+1<nums.length;i++){
            queue.add(new Pair(i,i+1));
        }
        Pair p = null;
        while(k-->0){
            p = queue.poll();
            if(p.p2+1<nums.length){
                queue.add(new Pair(p.p1,p.p2+1));
            }
        }
        return nums[p.p2] - nums[p.p1];
    }
    //计数排序
    public int smallestDistancePair(int[] nums, int k) {
        int ret = 0;
        int counter[] = new int[1000000];
        int idx = 0;
        int i = 0;
        int j = 0;
        for (i = 0; i < nums.length-1; i++)
        {
            for (j = i+1; j < nums.length; j++)
            {
                idx = nums[i]-nums[j];
                idx = Math.abs(idx);
                counter[idx]++;
            }
        }
        
        idx = 0;
        for (i = 0; i < 1000000; i++)
        {
            idx += counter[i];
            if (idx >= k)
            {
                ret = i;
                break;
            }
        }
        
        return ret;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,1};
        int k = 1;
        System.out.println(new Solution().smallestDistancePair(nums, k));
    }
}