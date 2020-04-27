import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
class Solution {
    HashMap<String,Integer> map;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        res = new ArrayList<>();
        dfs(root, map, res);
        return res;
    }
    public String dfs(TreeNode root,HashMap<String,Integer> map ,List<TreeNode> res){
        if(root==null){
            return "#";
        }
        String series = root.val + dfs(root.left, map, res) + dfs(root.right, map, res);
        Integer val = map.getOrDefault(series, 0)+1;
        if(val==2){
            res.add(root);
        }
        map.put(series, val);
        return series;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<TreeNode> res = new Solution().findDuplicateSubtrees(root);
        System.out.println(res);
    }
}