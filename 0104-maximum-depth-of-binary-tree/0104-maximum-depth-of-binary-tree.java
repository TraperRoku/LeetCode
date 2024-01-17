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
        public int maxDepth(TreeNode root) {
    if( root == null) return 0;
    return helper(root,0);
    }

    private int helper(TreeNode root, int licznik){
        if (root == null) return licznik;

        int left = helper(root.left,licznik+1);
        int right = helper(root.right,licznik+1);

       return licznik = Math.max(left,right);
    }
}