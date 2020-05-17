//  Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode new_head = new ListNode(-1); //最终新链表的头
        ListNode head_tmp = new_head; //每一个组的临时的头
        ListNode rear = new_head; //尾结点，便于到新组时赋给临时的头
        int len = 0;
        ListNode p = head;
        while(p!=null){
            len++;
            p = p.next;
        }
        int i=0;
        while(head!=null){
            if(len-i>=k){//将k个翻转 头插法
                for(int j=0;j<k;j++){
                    ListNode t = head.next;
                    head.next = head_tmp.next;
                    head_tmp.next = head;
                    head = t;
                    if(j==0){
                        rear = head_tmp.next;
                    }
                    i++;
                }
                head_tmp = rear;//为下一组做准备
            }else{ //不够k个 尾插法
                ListNode t = head.next;
                head.next = rear.next;
                rear.next = head;
                rear = head;
                head = t;
                i++;
            }

        }
        return new_head.next;
    }
}