class Solution{
    private int theBiggest = 0;

    private int helper(TreeNode root){

        if(root == null) return 0;

        int left = helper(root.left);
        int right= helper(root.right);

        theBiggest = Math.max(theBiggest,left+right);

        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return theBiggest;
    }
}