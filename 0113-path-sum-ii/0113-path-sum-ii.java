class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        dfs(root, targetSum, 0, output, new ArrayList<>());
        return output;
    }

    private void dfs(TreeNode root, int targetSum, int curSum,
                     List<List<Integer>> output, List<Integer> currentPath) {
        if (root == null) return;

        // Add current node's value to sum and path
        curSum += root.val;
        currentPath.add(root.val);

        // If it's a leaf and path sum equals target, add path to result
        if (root.left == null && root.right == null && curSum == targetSum) {
            output.add(new ArrayList<>(currentPath));
        }

        // Recur for children
        dfs(root.left, targetSum, curSum, output, currentPath);
        dfs(root.right, targetSum, curSum, output, currentPath);

        // Backtrack: remove current node
        currentPath.remove(currentPath.size() - 1);
    }
}