import java.util.ArrayList;
import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-23 09:26:20
 * @FilePath: \leetcode\234_回文链表\Solution1.java
 * @LastEditTime: 2020-10-23 09:49:02
 */
//  Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
class Solution1 {
    public boolean isPalindrome(ListNode head) {
        // 这里直接转成List 其实可以通过O(n),先用快慢指针找到中间节点，然后把后半部分进行reverse，再进行前半部分和后半部分比较，最后复原后半部分
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while(p!=null){
            list.add(p.val);
            p = p.next;
        }
        int i = 0,j = list.size() -1;
        while(i<j){
            System.out.println(list.get(i));
            System.out.println(list.get(j));
            if(list.get(i).equals(list.get(j))){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        ListNode head = new ListNode(-129);
        head.next = new ListNode(-129);
        System.out.println(new Solution1().isPalindrome(head));
    }
}