class Solution:
    def addTwoNumbers(self, l1, l2):
        head = curr = ListNode(0)
        carry = 0
        
        while l1 or l2 or carry:
            v1 = l1.val if l1 else 0
            v2 = l2.val if l2 else 0
            total = v1 + v2 + carry
            
            carry = total > 9
            curr.next = ListNode(total - 10 if carry else total)
            curr = curr.next
            
            if l1: l1 = l1.next
            if l2: l2 = l2.next
        
        return head.next