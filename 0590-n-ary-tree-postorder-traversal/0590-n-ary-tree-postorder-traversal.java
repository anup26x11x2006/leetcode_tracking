class Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Stack<Node> nodeStack = new Stack<>();
        Stack<Node> reverseStack = new Stack<>();

        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            Node currentNode = nodeStack.pop();
            reverseStack.push(currentNode);

            for (Node child : currentNode.children) {
                nodeStack.push(child);
            }
        }

        while (!reverseStack.isEmpty()) {
            Node currentNode = reverseStack.pop();
            result.add(currentNode.val);
        }

        return result;
    }
}