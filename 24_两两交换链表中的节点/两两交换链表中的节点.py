"""
Created on 2019/3/5 21:04
@File:两两交换链表中的节点.py
@author: coderwangson
"""
"#codeing=utf-8"


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        p = head
        r = None
        first = True
        if p :
            r = p.next
        while p and r:
            p.next = r.next
            r.next = p
            # 避免头结点丢掉
            if first:
                head = r
                first = False
            p = p.next
            if p:
                r = p.next
        return head
