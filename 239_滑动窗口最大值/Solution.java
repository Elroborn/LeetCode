import java.util.PriorityQueue;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length-k+1];
        for(int i=0;i+k-1<nums.length;i++){
            int t = nums[i];
            for(int j=i;j<i+k;j++){
                t = Math.max(t, nums[j]);
            }
            res[i] = t;
        }
        return res;
    }
    // 错误的方法
    public int[] maxSlidingWindow2(int[] nums, int k) { //用大顶堆存，堆顶一定是最大 
        int res[] = new int[nums.length-k+1];
        final int DEFAULT_INITIAL_CAPACITY = 11;
        //默认是小顶堆
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(DEFAULT_INITIAL_CAPACITY, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {                
            return o2-o1;
        }
        });

        return res;
    }
    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int res[] = new Solution().maxSlidingWindow(nums, 3);
        for(int i:res){
            System.out.println(i);
        }
    }
}