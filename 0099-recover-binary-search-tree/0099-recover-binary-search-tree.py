class Solution(object):
    def recoverTree(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: None Do not return anything, modify root in-place instead.
        """
        first, second, prev, pred = None, None, None, None

        while root:
            if root.left:
                pred = root.left
                while pred.right and pred.right != root:
                    pred = pred.right

                if not pred.right:
                    pred.right = root
                    root = root.left
                else:
                    if prev and prev.val > root.val:
                        if not first:
                            first = prev
                        second = root
                    pred.right = None
                    prev = root
                    root = root.right
            else:
                if prev and prev.val > root.val:
                    if not first:
                        first = prev
                    second = root
                prev = root
                root = root.right

        if first and second:
            first.val, second.val = second.val, first.val