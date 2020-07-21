/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-21 10:56:04
 * @FilePath: \leetcode\95_不同的二叉搜索树 II\Solution.java
 * @LastEditTime: 2020-07-21 11:20:48
 */ 
import java.util.ArrayList;
import java.util.List;
//Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> res = new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }
        for(int i = start;i<=end;i++){
            List<TreeNode> leftTrees = generateTrees(start,i-1);
            List<TreeNode> rightTrees = generateTrees(i+1,end);
            for(TreeNode leftTree : leftTrees){
                for(TreeNode rightTree : rightTrees){
                    TreeNode curr = new TreeNode(i);
                    curr.left = leftTree;
                    curr.right = rightTree;
                    res.add(curr);
                }
            }
            
        }
        return res;
        
    }
}