import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;
import java.util.Comparator;

class Pair{
    int a;
    int b;
    public Pair(int a,int b){
        this.a = a;
        this.b = b;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[k];
        for(int i =0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair o1, Pair o2) {
                return o2.b - o1.b;
            }
        });
        for(Entry<Integer,Integer> entry:map.entrySet()){
            queue.add(new Pair(entry.getKey(),entry.getValue()));
        }
        for(int i=0;i<k;i++){
            res[i] = queue.poll().a;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3,3};
        int[] res = new Solution().topKFrequent(nums, 3);
        for(int i:res){
            System.out.println(i);
        }
    }
}