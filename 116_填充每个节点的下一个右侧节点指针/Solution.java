import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-15 19:46:55
 * @FilePath: \leetcode\116_填充每个节点的下一个右侧节点指针\Solution.java
 * @LastEditTime: 2020-10-15 19:50:53
 */
// Definition for a Node.
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
        if(root == null){
            return root;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        int size = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0;i<size;i++){
                Node t = queue.poll();
                if(i<size-1){
                    t.next = queue.peek();
                }
                if(t.left!=null){
                    queue.add(t.left);
                }
                if(t.right!=null){
                    queue.add(t.right);
                }
            }
        }
        return root;
    }
}