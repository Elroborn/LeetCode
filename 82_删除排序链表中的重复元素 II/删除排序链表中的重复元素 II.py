"""
Created on 19.9.16 19:02
@File:删除排序链表中的重复元素 II.py
@author: coderwangson
"""
"#codeing=utf-8"


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None



class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None or head.next == None:
            return head
        new_head = ListNode(None)
        tmp = None
        r = new_head
        while head:
            next = head.next
            if (next ==None and head.val !=tmp) or (next!=None and head.val!=tmp and head.val !=next.val):
                r.next = head
                r = head
                r.next = None
            tmp = head.val
            head = next



        return new_head.next


head = ListNode(1)
r = head
for i in [2,2]:
    s = ListNode(i)
    r.next = s
    r = s

head = Solution().deleteDuplicates(head)
while head:
    print(head.val)
    head = head.next