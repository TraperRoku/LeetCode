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
    private int licznik = 0;
    private int official = 0;
    
    public int kthSmallest(TreeNode root, int k) {
    helper(root,k);
    return official;
    }

    private void helper(TreeNode root , int k){
        if(root == null) return;
        
        helper(root.left,k);
        
        licznik++;
        if(licznik==k){
            official = root.val;
        }
        helper(root.right,k);
    }
}