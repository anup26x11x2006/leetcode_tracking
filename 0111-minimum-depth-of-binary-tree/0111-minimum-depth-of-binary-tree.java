class Solution {
    public int minDepth(TreeNode root) {
        int result=buildTree(root);
        return result;
    }

    public static int buildTree(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftNodes=buildTree(root.left);
        int rightNodes=buildTree(root.right);

        if (root.left == null) return rightNodes + 1;
        if (root.right == null) return leftNodes + 1;

        return Math.min(leftNodes,rightNodes)+1;
    }
}