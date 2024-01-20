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
    public int goodNodes(TreeNode root) {
    return helper(root,root.val,0);
    }
    private int helper(TreeNode root, int maxVal,int licznik){
        if(root == null) return 0;

        if(root.val>= maxVal){
            licznik++;
        }
        maxVal = Math.max(maxVal,root.val);

        licznik+= helper(root.left,maxVal,0);
        licznik+= helper(root.right,maxVal,0);

        return licznik;
    }
}