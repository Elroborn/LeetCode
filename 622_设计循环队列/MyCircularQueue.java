class MyCircularQueue {
    int[] data;
    int front,rear;
    int capacity;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        capacity = k+1; //因为浪费一个作为判断条件
        front = 0;
        rear = 0;
        data = new int[capacity];
        
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()){
            data[rear] = value;
            rear = (rear+1)%capacity;
            return true;
        }else{
            return false;
        }
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()){
            front = (front+1)%capacity;
            return true;
        }else{
            return false;
        }
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(!isEmpty()){
            return data[front];
        }else{
            return -1;
        }
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(!isEmpty()){
            return data[(rear-1+capacity)%capacity];
        }else{
            return -1;
        }
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front==rear;

    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (rear+1)%capacity ==front;

    }
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean param_1 = obj.enQueue(1);
        System.out.println(obj.rear);
        boolean param_2 = obj.deQueue();
        System.out.println(obj.isEmpty());
        int param_4 = obj.Rear();
        boolean param_5 = obj.isEmpty();
        boolean param_6 = obj.isFull();
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */