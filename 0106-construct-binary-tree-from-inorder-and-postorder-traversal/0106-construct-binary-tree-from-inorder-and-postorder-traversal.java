class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        TreeNode root = build(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
    static TreeNode build(int[] postorder,int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer,Integer> map){
        if(pStart > pEnd || iStart > iEnd) return null;
        TreeNode root = new TreeNode(postorder[pEnd]);
        int rootIndex = map.get(postorder[pEnd]);
        int numLeft = rootIndex - iStart; // number of nodes in left
        root.left = build(postorder,pStart,pStart+numLeft-1,inorder,iStart,rootIndex-1,map);
        root.right = build(postorder,pStart+numLeft,pEnd-1,inorder,rootIndex+1,iEnd,map);
        return root;
    }
}