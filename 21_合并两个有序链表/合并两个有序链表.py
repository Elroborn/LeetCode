"""
Created on 2019/3/1 19:53
@File:合并两个有序链表.py
@author: coderwangson
"""
"#codeing=utf-8"


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        # 返回结点的头结点
        h =ListNode(-1)
        h.next = None
        r = h

        while l1 and l2:
            if l1.val<l2.val:
                r.next = l1
                r = l1
                l1 = l1.next
            else:
                r.next =l2
                r = l2
                l2 = l2.next
        if l2:
            l1 = l2
        while l1:
            r.next = l1
            r = l1
            l1 = l1.next
        r.next = None
        return h.next







l1 = ListNode(1)
r = l1
l1.next = None
import numpy as np
n = np.random.randint(1,100,[4])
n = sorted(n)
print(n)
for i in n:
    node = ListNode(i)
    node.next = None
    r.next = node
    r =node


l2 = ListNode(5)
r = l2
l2.next = None
n = np.random.randint(6,100,[6])
n = sorted(n)
for i in n:
    node = ListNode(i)
    node.next = None
    r.next = node
    r =node

l = Solution().mergeTwoLists(l1,l2)
p = l
while p.next:
    print(p.val)
    p =p.next



