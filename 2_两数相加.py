'''
Created on 2018年11月22日

@author: coderwangson
'''
"#codeing=utf-8"

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        p = l1
        q = l2
        res = None
        l =None
        s = 0 # 进位
        # 当然也可以做成带头结点返回为res.next即可
        while(p!=None and q!=None):
            v = p.val+q.val + s
            s = v//10
            v = v%10
            if res ==None:
                res = ListNode(v)
                l =res
            else:
                r = ListNode(v)
                l.next = r
                l = l.next
            p = p.next
            q = q.next
        if q!=None:
            p = q
        while p!=None:
            v = p.val+ s
            s = v//10
            v = v%10
            if res ==None:
                res = ListNode(v)
                l = res
            else:
                r = ListNode(v)
                l.next = r
                l = l.next
            p = p.next
        if s !=0:
            r = ListNode(s)
            l.next = r
            l = l.next
            
        return res
            
l1 = ListNode(1)
l2 = ListNode(9)
l2.next = ListNode(9)      
# l2.next.next = ListNode(4)
s = Solution()
print(s.addTwoNumbers(l1, l2))       
