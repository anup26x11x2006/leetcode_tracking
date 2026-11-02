class Solution {
    Queue<TreeNode> queue = new LinkedList<>();
    public void flatten(TreeNode root) {
        if(root == null) return;
        getNodes(root);

        TreeNode previousNode = queue.poll();

        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            previousNode.left = null;
            previousNode.right = currentNode;
            previousNode = currentNode;
        }
    }

    void getNodes(TreeNode node){
        if(node == null){
            return;
        }
        
        queue.offer(node);
        getNodes(node.left);
        getNodes(node.right);
    }
}