"""
Created on 2019/3/7 21:57
@File:k个一组翻转链表.py
@author: coderwangson
"""
"#codeing=utf-8"


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def headInsertByN(self,head,nodes,n):
        r = head
        tmp = nodes
        for i in range(n):
            if tmp is None:
                break
            tmp = tmp.next

        for i in range(n):
            p = nodes
            nodes = nodes.next

            # 头插
            p.next = head.next
            head.next = p
            r = p
        return r,nodes

    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
