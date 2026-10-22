class ListNode:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head):
        if not head or not head.next:
            return head

        dummy = ListNode(0, head)
        prev = dummy
        current = head

        while current:
            is_duplicate = False

            while current.next and current.val == current.next.val:
                is_duplicate = True
                current = current.next

            if is_duplicate:
                prev.next = current.next
            else:
                prev = prev.next

            current = current.next

        return dummy.next