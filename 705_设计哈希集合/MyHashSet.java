class MyHashSet {
    //目前使用数组一个桶一个数据，进阶版本可以桶用List，这样减少空间，因为可以hash到一个位置
    //再进阶可以将List换成二叉搜索树，这样可以加快寻找速度（因为List是顺序）
    char[] hasset; //用char可以减少空间等
    /** Initialize your data structure here. */
    public MyHashSet() {
        hasset = new char[1000000];
    }
    
    public void add(int key) {
        hasset[key] = 1;
    }
    
    public void remove(int key) {
        hasset[key] = 0;

    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(hasset[key]==0){
            return false;
        }else{
            return true;
        }

    }
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
      
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */