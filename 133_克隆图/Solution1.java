import java.util.HashMap;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-12 09:37:55
 * @FilePath: \leetcode\133_克隆图\Solution1.java
 * @LastEditTime: 2020-08-12 10:05:13
 */
/*
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
*/

class Solution1 {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> vis = new HashMap<>();
        return dfs(node, vis);
    }
    public Node dfs(Node node,HashMap<Node,Node> vis){
        if(node==null){
            return null;
        }
        if(vis.containsKey(node)){
            return vis.get(node);
        }

        Node new_node = new Node(node.val);
        vis.put(node, new_node);
        for(Node t:node.neighbors){
            new_node.neighbors.add(dfs(t, vis));
        }
        return new_node;
    }
}