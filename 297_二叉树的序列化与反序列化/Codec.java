import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            if(t!=null){
                res+=(String.valueOf(t.val)+",");
                q.add(t.left);
                q.add(t.right);

            }else{
                res+=("null"+",");
            }
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        TreeNode root = getNode(nodes[0]);
        TreeNode parent = root;
        boolean isLeft = true;
        Queue<TreeNode> p = new LinkedList<>();
        for(int i = 1;i<nodes.length;i++){
            TreeNode t = getNode(nodes[i]);
            if(isLeft){
                parent.left = t;
            }else{
                parent.right = t;
            }
            if(t!=null){
                p.add(t);
            }
            isLeft = !isLeft;
            if(isLeft){
                parent = p.poll();
            }
        }
        return root;
    }
    TreeNode getNode(String s){
        if(s.equals("null")){
            return null;
        }else{
            return new TreeNode(Integer.valueOf(s));
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        right.left = new TreeNode(4);
        right.right = new TreeNode(5);
        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
        // codec.deserialize("1,2,3,null,null,4,5,null,null,null,null");

        
    }
}
