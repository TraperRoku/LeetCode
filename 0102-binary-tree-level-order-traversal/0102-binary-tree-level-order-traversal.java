import java.util.*;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null) return new ArrayList<>();
    List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {

            int sizeQueue = queue.size();

            List<Integer> backpack = new ArrayList<>();

            for (int i = 0; i < sizeQueue; i++) {

                TreeNode temp = queue.poll();
                backpack.add(temp.val);

                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);


            }
            list.add(backpack);
        }
        return list;
    
    }

}