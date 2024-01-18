/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
    if(root == null) return true;

    int left = helper(root.left,0);
    int right = helper(root.right,0);

    if(Math.abs(left - right)>1){
        return false;
    }
    return isBalanced(root.right) && isBalanced(root.left);
    }


    private int helper(TreeNode root, int licznik){
        if(root == null) return licznik;

        int left = helper(root.left,licznik+1);
        int right = helper(root.right,licznik+1);

        return Math.max(left,right);
    }
}