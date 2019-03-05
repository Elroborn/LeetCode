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
    @staticmethod
    def mergeTwoLists(l1, l2):
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

    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        # 先把 lists里面的按照长度排序，这样避免长的先合并，导致效率低
        # sorted(lists,key=len)
        if len(lists)>0:
            l1 = lists[0]
        i = 1
        while i<len(lists):
            l1 = Solution.mergeTwoLists(l1,lists[i])
            i+=1
        return l1

