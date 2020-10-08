/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-08 08:58:08
 * @FilePath: \leetcode\剑指 Offer 58 二叉树的下一个结点\Solution.java
 * @LastEditTime: 2020-10-08 09:17:33
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        //最简单的，先找到根节点，然后中序一遍
        //复杂的分左右子树
        if(pNode==null){
            return null;
        }
        //右树不空，则右的最左即可
        if(pNode.right!=null){
            TreeLinkNode t = pNode.right;
            if(t.left!=null){
                t = t.left;
            }
            return t;
        }
        //没有右 则看父
        while(pNode.next!=null){
            if(pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
        
    }
}