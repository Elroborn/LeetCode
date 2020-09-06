import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-06 09:48:06
 * @FilePath: \leetcode\107_二叉树的层次遍历 II\Solution.java
 * @LastEditTime: 2020-09-06 10:17:11
 */
//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int s = queue.size();
            for(int i = 0;i<s;i++){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            stack.push(tmp);
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;

    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(new int[]{1});
    }
}