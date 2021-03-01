import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_1676 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        List<TreeNode> list = new ArrayList<>(Arrays.asList(nodes));
        return dfs(root, list);
    }

    private TreeNode dfs(TreeNode root, List<TreeNode> nodes) {
        if(root == null || nodes.contains(root)) return root;

        TreeNode left = dfs(root.left, nodes);
        TreeNode right = dfs(root.right, nodes);

        if(left != null && right != null) return root;
        return left == null ? right : left;
    }
}
