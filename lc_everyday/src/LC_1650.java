import java.util.HashSet;
import java.util.Set;

public class LC_1650 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node lowestCommonAncestor(Node p, Node q) {
        // 第一种方法同 160
        // Node p1 = p, p2 = q;
        // while (p1 != p2) {
        // p1 = p1 == null ? q : p1.parent;
        // p2 = p2 == null ? p : p2.parent;
        // }
        // return p1;

        // 第二种
        Set<Node> set = new HashSet<>();
        while (p != null || q!= null) {
            if (p != null && !set.contains(p)) {
                set.add(p);
                p = p.parent;
            } else if (p != null) {
                return p;
            }
            if (q != null && !set.contains(q)) {
                set.add(q);
                q = q.parent;
            } else if (q != null) {
                return q;
            }
        }
        return null;
    }
}
