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
    private int p = 0;
    private int k = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree2(preorder,inorder,Integer.MIN_VALUE);
    }
    private TreeNode buildTree2(int[]preorder, int[] inorder,int stop){
        if(p>= preorder.length){
            return null;
        }
        if(inorder[k] == stop ){
            k++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[p++]);
        root.left = buildTree2(preorder,inorder, root.val);
        root.right = buildTree2(preorder,inorder,stop);
        return root;
    }
}