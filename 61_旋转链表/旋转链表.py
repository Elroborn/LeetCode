"""
Created on 2019/5/5 17:27
@File:旋转链表.py
@author: coderwangson
"""
"#codeing=utf-8"


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if head==None or head.next ==None:
            return head
        p = head
        l = 0 # 长度
        while p:
            l+=1
            p = p.next
        p = head
        q = head
        i = 0
        k = k%l
        while p.next:
            if i>=k:
                q = q.next
            p = p.next
            i+=1
        p.next = head
        head = q.next
        q.next = None
        return head
def show(head):
    p = head
    while p:
        print(p.val)
        p = p.next
head = ListNode(0)
r = head
head.next = None
for i in range(1,3):
    node = ListNode(i)
    r.next = node
    r = node
    r.next = None
# show(head)
print(show(Solution().rotateRight(head,4)))



