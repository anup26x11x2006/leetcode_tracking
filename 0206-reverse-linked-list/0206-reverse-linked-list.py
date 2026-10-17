class Solution:
    def reverseList(self, head):
        node = None

        while head:
            temp = head.next
            head.next = node
            node = head
            head = temp
        
        return node