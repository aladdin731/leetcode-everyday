import java.util.LinkedList;
import java.util.Queue;

public class LC_1740 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode node = lowestCommonAncestor(root, p, q);
        if(node.val == p) {
            return deep(node, q);
        }else if (node.val == q) {
            return deep(node, p);
        }else {
            return deep(node, q) + deep(node, p);
        }
    }

    private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null || root.val == p || root.val == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        return left == null ? right : left;
    }

    private int deep(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int deep = 0;
        while(q.size() != 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                if(cur.val == k) return deep;
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
            deep += 1;
        }
        return deep;
    }
}
