import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-12 10:53:50
 * @FilePath: \leetcode\637_二叉树的层平均值\Solution.java
 * @LastEditTime: 2020-09-12 10:59:58
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size;
        double tmp;
        while(!queue.isEmpty()){
            size = queue.size();
            tmp = 0;
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                tmp+=node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(tmp/size);
        }
        return res;

    }
}