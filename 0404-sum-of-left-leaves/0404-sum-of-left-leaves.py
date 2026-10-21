
class Solution:
    def sumOfLeftLeaves(self, root):
        if root is None:
            return 0

        total = 0

        if root.left:
            if root.left.left is None and root.left.right is None:
                total += root.left.val
            else:
                total += self.sumOfLeftLeaves(root.left)

        total += self.sumOfLeftLeaves(root.right)

        return total