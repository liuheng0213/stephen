package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

/**
 * 在二叉树中找到两个节点得最近公共祖先
 */
public class _10CommonAncestor {
    public Node lowestCommonAncestor(Node root, Node o1, Node o2) {
        if (root == null || root == o1 || root == o2) {
            return root;
        }

        Node left = lowestCommonAncestor(root.left, o1, o2);
        Node right = lowestCommonAncestor(root.right, o1, o2);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
