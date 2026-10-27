class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            List<Integer> current = new ArrayList<>();
            int level = q.size();

            for (int i = 0; i < level; i++) {
                if (!reverse) {
                    TreeNode curr = q.pollFirst();
                    current.add(curr.val);
                    if (curr.left != null) q.addLast(curr.left);
                    if (curr.right != null) q.addLast(curr.right);
                } else {
                    TreeNode curr = q.pollLast();
                    current.add(curr.val);
                    if (curr.right != null) q.addFirst(curr.right);
                    if (curr.left != null) q.addFirst(curr.left);
                }
            }

            res.add(current);
            reverse = !reverse;
        }

        return res;
    }
}