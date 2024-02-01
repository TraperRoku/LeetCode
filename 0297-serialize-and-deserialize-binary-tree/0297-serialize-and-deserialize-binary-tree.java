import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private List<String> list = new ArrayList<>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    dfsSer(root);
    return String.join(",",list);
    }
    private void dfsSer(TreeNode root){
        if(root == null) {
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.val));
        dfsSer(root.left);
        dfsSer(root.right);
    }
    private int i = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data2 = data.split(",");
    return dfsDes(data2);
    }
    private TreeNode dfsDes(String[] data){
    if(data[i].equals("N")) {
        i++;
        return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(data[i]));
    i++;
    root.left = dfsDes(data);
    root.right = dfsDes(data);

    return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));