from collections import deque

class Solution(object):
    def zigzagLevelOrder(self, root):
        if not root:
            return []

        result = []
        queue = deque([root])
        is_left_to_right = True

        while queue:
            level_size = len(queue)
            current_level = [0] * level_size

            for i in range(level_size):
                node = queue.popleft()
                index = i if is_left_to_right else level_size - 1 - i
                current_level[index] = node.val

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            result.append(current_level)
            is_left_to_right = not is_left_to_right

        return result