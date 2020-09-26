import java.util.ArrayList;
import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-26 09:15:40
 * @FilePath: \leetcode\113_路径总和 II\Solution.java
 * @LastEditTime: 2020-09-26 09:43:14
 */
//  Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(root,res,tmp,sum);
        return res;

    }

    private void dfs(TreeNode root, List<List<Integer>> res, List<Integer> tmp, int sum) {
        if(root==null){
            return;
        }
        if(sum==root.val && root.left==null && root.right==null){
            List<Integer> t = new ArrayList<>(tmp);
            t.add(root.val);
            res.add(t);
            return;
        }
        tmp.add(root.val);
        dfs(root.left, res, tmp, sum-root.val);
        dfs(root.right, res, tmp, sum-root.val);
        tmp.remove(tmp.size()-1);
    }
}