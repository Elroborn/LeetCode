"""
Created on 2019/2/27 22:17
@File:删除链表的倒数第N个节点.py
@author: coderwangson
"""
"#codeing=utf-8"


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        # 增加头结点，因为没有头结点做起来不好做
        l = ListNode(-1)
        l.next = head
        i = 1
        r = l
        q = l.next
        while q.next:
            if i >=n:
                r = r.next
            q = q.next
            i += 1

        if r.next:
            r.next = r.next.next

        return l.next



head = ListNode(1)
head.next = None
r = head
for i in range(2,3):
    node = ListNode(i)
    node.next = None
    r.next =node
    r = node
head = Solution().removeNthFromEnd(head,2)
q = head
while q:
    print(q.val)
    q = q.next
