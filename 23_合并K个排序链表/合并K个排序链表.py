"""
Created on 2019/3/5 19:53
@File:合并K个排序链表.py
@author: coderwangson
"""
"#codeing=utf-8"


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        all_node = []
        for l in lists:
            p = l
            while p:
                all_node.append(p.val)
                p = p.next
        # 这样插入排序就可以头插法了
        all_node = sorted(all_node,reverse=True)
        h = ListNode(-1)
        h.next = None
        for n in all_node:
            node = ListNode(n)
            node.next = h.next
            h.next = node
        return h.next
