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
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> biggerList = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();



            for(int i =0; i<size ;i ++){
                TreeNode temp = queue.poll();

                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);

                list.add(temp.val);
            }
            biggerList.add(list);


        }
        return biggerList;

    }
}