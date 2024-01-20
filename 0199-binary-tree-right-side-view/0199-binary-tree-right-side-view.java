import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null ) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> list = new ArrayList<>();


        while (!queue.isEmpty()){
            TreeNode right = null;
            int size = queue.size();

            for(int i =0; i < size;i++){
                TreeNode temp = queue.poll();
                
                if(temp !=null){
                    queue.add(temp.left);
                    queue.add(temp.right);
                    right = temp;
                }
            }
            if(right!=null) list.add(right.val);
        }
        return list;
    }
}