'''
Created on 2018年11月22日

@author: coderwangson
'''
"#codeing=utf-8"

# Definition for singly-linked list.
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
        res = ListNode(0)
        r = res
        s = 0 # 进位
        # 当然也可以做成带头结点返回为res.next即可
        while(p!=None or q!=None):
            p_v = 0 if p==None else p.val
            q_v = 0 if q==None else q.val
            r_v = (p_v+q_v+s)%10
            s = (p_v+q_v+s)//10
            r.next = ListNode(r_v)
            r = r.next
            r.next = None
            # 如果不为None的时候继续遍历，否则停止遍历
            p =p if p==None else p.next
            q =q if q==None else q.next
        if s !=0:
            r.next = ListNode(s)
            r = r.next
            r.next = None
        return res.next
l1 = ListNode(0)
l2 = ListNode(1)
l2.next = ListNode(8)      
s = Solution()
print(s.addTwoNumbers(l1, l2))       
