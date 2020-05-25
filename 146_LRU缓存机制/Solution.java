import java.util.HashMap;
class DLinkedNode{ // 双向链表结点 之所以用双链表是为了方便的对头部和尾部进行增加和删除，因为要经常移动到头部以及删除尾部元素
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode next;
    public DLinkedNode(){}
    public DLinkedNode(int _key,int _value){
        this.key = _key;
        this.value = _value;
    }

}
public class LRUCache {
    HashMap<Integer,DLinkedNode> data; // 只是为了实现O(1)时间访问 达到快速在链表中定位
    DLinkedNode head;
    DLinkedNode tail; // 类似与单链表，带头节点方便删除等操作 省的判断是否空表
    int capacity;


    public LRUCache(int capacity) {
        data = new HashMap<Integer,DLinkedNode>();
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DLinkedNode node = data.get(key);
        if(node==null){
            return -1;
        }
        moveHead(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        DLinkedNode node = data.get(key); // 先看有没有
        if(node ==null){ // 没有
            node = new DLinkedNode(key,value);
            data.put(key, node);
            addHead(node);
            //先添加在看容量
            if(data.size()>capacity){
                DLinkedNode last = removeTail();
                data.remove(last.key);
            }
        }else{ //已经有了，则直接移动到头部即可
            node.value = value;
            moveHead(node);
        }
    }
    private void removeNode(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private void addHead(DLinkedNode node){ //加到head头部，这个是在访问后使用
        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        node.pre.next = node;
    }
    private void moveHead(DLinkedNode node){
        removeNode(node);
        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        node.pre.next = node;
    }
    private DLinkedNode removeTail(){ // 超出容量删除
        //返回值是为了删除hashmap对应元素用的
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */