import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
//Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
class Solution {
    HashMap<Integer,TreeNode> map = new HashMap<>();
    // 找到每个结点的父亲，存储到HashMap里面(node,node`s parent) ,这样我们如果找p，则p的父亲，p的父亲的父亲都可以找到了
    public void findParent(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            map.put(root.left.val, root);
            findParent(root.left);
        }
        if(root.right!=null){
            map.put(root.right.val, root);
            findParent(root.right); 
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findParent(root);
        HashSet<Integer> set = new HashSet<>();
        while(p!=null){
            set.add(p.val);
            p = map.get(p.val);
        }
        while(q!=null){
            if(set.contains(q.val)){
                return q;
            }else{
                set.add(q.val);
                q = map.get(q.val);
            }
        }

        return null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        System.out.println(new Solution().lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);
    }
}