class Solution {
    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int level = q.size();
            while (level-- > 0) {
                Node curr = q.poll();
                if (level != 0) curr.next = q.peek();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return root;
    }
}