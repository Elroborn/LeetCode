import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Pair{
    int first;
    int second;
    public Pair(int v1,int v2){
        this.first = v1;
        this.second = v2;
    }
}
class Bucket{
    List<Pair> bucket;
    public Bucket(){
        bucket = new ArrayList<>();
    }
    public void update(int key,int value){
        boolean found = false;
        for(Pair p :bucket){
            if(p.first==key){
                p.second = value;
                found = true;
            }
        }
        if(!found){
            bucket.add(new Pair(key,value));
        }
    }
    public void remove(int key){
        for(Pair p :bucket){
            if(p.first==key){
                this.bucket.remove(p);
                break;
            }
        }
    }
    public int get(int key){
        for(Pair p :bucket){
            if(p.first==key){
                return p.second;
            }
        }
        return -1;
    }

}

public class MyHashMap {
    Bucket[] map;
    int hash_f = 2069;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new Bucket[hash_f];
        Arrays.fill(map, new Bucket());
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key%this.hash_f].update(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key%this.hash_f].get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key%this.hash_f].remove(key);
    }
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1); 
        hashMap.put(2, 2); 
        System.out.println(hashMap.get(1));// 返回 1
        System.out.println(hashMap.get(3)); // 返回 -1 (未找到)
        hashMap.put(2, 1); // 更新已有的值
        System.out.println(hashMap.get(2));// 返回 1 
        hashMap.remove(2); // 删除键为2的数据
        System.out.println(hashMap.get(2));// 返回 -1 (未找到) 

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */