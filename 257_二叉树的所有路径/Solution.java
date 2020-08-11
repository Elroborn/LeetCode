/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-11 10:02:37
 * @FilePath: \leetcode\257_二叉树的所有路径\Solution.java
 * @LastEditTime: 2020-08-11 10:10:44
 */
import java.util.List;
import java.util.ArrayList;
// Definition for a binary tree node.
class TreeNode {
   int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class Solution {
    private List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if(root==null){
            return res;
        }
        dfs(root, "");
        return res;
    }
    public void dfs(TreeNode root,String tmp){
        if(root.left == null && root.right ==null){
            if(tmp.length()==0){
                tmp+=root.val;
            }else{
                tmp+=("->"+root.val);
            }
            res.add(tmp);
        }
        if(root.left!=null){
            if(tmp.length()==0){
                dfs(root.left, tmp+root.val);
            }else{
                dfs(root.left, tmp+ "->"+root.val);
            }
        }
        if(root.right!=null){
            if(tmp.length()==0){
                dfs(root.right, tmp+root.val);
            }else{
                dfs(root.right, tmp+"->"+root.val);
            }
        }
    }
}