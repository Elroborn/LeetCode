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
       #可以看做是遍历一遍，只是每此把遍历的这个结点的后两个交换下位置即可
        h = ListNode(-1)
        h.next = head
        pre = h
        # 如果后面有两个结点
        while pre.next and pre.next.next:
            p = pre.next
            q = p.next

            pre.next = q
            p.next = q.next
            q.next =p

            pre = p

        return h.next


