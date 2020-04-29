import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
class RandomizedSet {
    HashMap<Integer,Integer>map; //用来做元素和数组中位置映射，这样用list可以做随机查，用map位置映射，则可以在删除的时候快速在list中找到待删除的位置
    java.util.List<Integer> list;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new java.util.ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size()); // size是位置
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        // 用map找到位置
        int index = map.get(val);
        int lastval = list.get(list.size()-1);
        map.put(lastval, index); // 因为会出现一个元素情况，所以一定要先放入，再删除，否则先删除，再放入会变成没有删除
        map.remove(val);
        //删除的时候选择将其和末尾元素交换（用末尾元素覆盖其即可），注意更新map，再删除，这样是O(1)
        list.set(index, lastval);
        list.remove(list.size()-1); //移除末尾，O(1)
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */