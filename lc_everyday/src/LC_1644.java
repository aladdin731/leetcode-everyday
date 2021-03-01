public class LC_1644 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(exist(root, p.val) == false || exist(root,q.val) == false) return null;
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);

        if(left != null && right != null) return root;
        return left == null ? right : left;
    }

    private boolean exist(TreeNode root, int k) {
        if(root == null) return false;
        if(root.val == k) return true;
        return exist(root.left, k) || exist(root.right, k);
    }
}
