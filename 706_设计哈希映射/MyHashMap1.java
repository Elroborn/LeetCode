import java.util.Arrays;

class MyHashMap1 {
    int[] map;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[1000000];
        Arrays.fill(map, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];

    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = -1;

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