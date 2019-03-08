"""
Created on 2019/3/7 21:57
@File:k个一组翻转链表.py
@author: coderwangson
"""
"#codeing=utf-8"

# ref https://blog.csdn.net/qq_17550379/article/details/80696835
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def headInsertByN(self,pre,last):
        # 把pre->last之间的结点逆转
        # 其实就是把pre->last进行头插法，最终返回L即可
        L = ListNode(-1)
        L.next = None
        r = pre
        end = last.next
        while pre != end:
            p = pre
            pre = pre.next

            # 头插
            p.next = L.next
            L.next = p

        return L.next,r

    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        # 遍历，每次把部分结点传入上面那个逆转的函数
        # 然后把所有逆转后的结点尾插即可
        L = ListNode(-1)
        L.next = None
        r = L
        pre = head
        last = pre
        i = 1
        while pre and last:
            if i%k ==0:
                pre_tmp = last.next
                p,r_temp = Solution().headInsertByN(pre,last)
                r.next = p
                r = r_temp
                pre = pre_tmp
                last = pre
                i = 1
                continue
            last = last.next
            i+=1
        r.next = pre
        return L.next

ls = [1,2,3,4,5]
head = ListNode(-1)
head.next = None
r = head
for i in ls:
    p =ListNode(i)
    p.next = None
    r.next = p
    r = p
q = head.next
q = Solution().reverseKGroup(q,3)
while q is not None:
    print(q.val)
    q = q.next


