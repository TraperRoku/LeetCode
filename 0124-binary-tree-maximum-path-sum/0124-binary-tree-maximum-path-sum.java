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
    public int maxPathSum(TreeNode root) {
    int[] res = {root.val};
      dfs(root,res);
      return res[0];
    }

    private int dfs(TreeNode root, int[] res){
        if(root == null) return 0;

        int left = dfs(root.left,res);
        int right = dfs(root.right,res);

        int maxLeft = Math.max(left,0);
        int maxRight = Math.max(right,0);

        res[0] = Math.max(maxLeft + maxRight+root.val, res[0]);

        return root.val + Math.max(maxLeft,maxRight);
    }
}