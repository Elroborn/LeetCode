import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        Set<Integer> visited = new HashSet<>();
        return dfs(node, visited);
    }
    public Node dfs(Node node,Set<Integer> visited){
        Node new_node = new Node(node.val);
        for(Node n:node.neighbors){
            if(!visited.contains(n.val)){
                visited.add(n.val);
                new_node.neighbors.add(dfs(n,visited));
                visited.remove(n.val);
            }
        }
        return new_node;
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.neighbors.add(new Node(2));
        node.neighbors.add(new Node(3));
        Node new_node = new Solution().cloneGraph(node);
        System.out.println(new_node.neighbors.get(1).val);
    }
}