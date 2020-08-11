import java.util.ArrayList;
import java.util.List;
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-11 10:15:19
 * @FilePath: \leetcode\257_二叉树的所有路径\Solution1.java
 * @LastEditTime: 2020-08-11 10:29:15
 */
class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution1 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        List<String> tmp = new ArrayList<>();
        backTrack(root,res,tmp);
        return res;
    }
    public void backTrack(TreeNode root,List<String> res,List<String> tmp){
        tmp.add(root.val+"");
        if(root.left == null && root.right == null){
            buildPath(res,tmp);
        }else{
            if(root.left!=null){
                backTrack(root.left, res, tmp);
            }
            if(root.right!=null){
                backTrack(root.right, res, tmp);
            }
        }
        tmp.remove(tmp.size()-1);
    }
    public void buildPath(List<String> res,List<String> tmp){
        StringBuilder s = new StringBuilder();
        for(int i = 0;i<tmp.size();i++){
            s.append(tmp.get(i));
            if(i!=tmp.size()-1){
                s.append("->");
            }
        }
        res.add(s.toString());
    }
    public static void main(String[] args) {
        // StringBuilder sb = new StringBuilder();
        // sb.append("2");
        // sb.append("3");
        // sb.deleteCharAt(sb.length()-1);
        // System.out.println(sb.toString());
        
    }
}