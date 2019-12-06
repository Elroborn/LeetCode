"""
Created on 19.9.18 20:41
@File:删除排序链表中的重复元素.py
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
        new_head = ListNode(None)
        rear = new_head
        while head:
            if head.val != rear.val:
                rear.next = head
                rear = head

            head = head.next
        rear.next = None
        return new_head.next



head = ListNode(1)
r = head
for i in [1,2,3,3]:
    s = ListNode(i)
    r.next = s
    r = s

head = Solution().deleteDuplicates(head)
while head:
    print(head.val)
    head = head.next