import java.util.LinkedList;
import java.util.Queue;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-28 08:45:36
 * @FilePath: \leetcode\117_填充每个节点的下一个右侧节点指针 II\Solution.java
 * @LastEditTime: 2020-09-28 08:49:57
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        int size = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0;i<size;i++){
                Node t = queue.poll();
                if(i+1<size){
                    t.next = queue.peek();
                }else{
                    t.next = null;
                }
                if(t.left!=null){
                    queue.offer(t.left);
                }
                if(t.right!=null){
                    queue.offer(t.right);
                }
            }
        }
        return root;
        
    }
}