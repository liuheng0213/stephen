package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

/**
 * 在二叉树中找到两个节点得最近公共祖先
 */
public class _10CommonAncestor {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.right.left = new Node(4);
        head.right.right = new Node(5);

        _10CommonAncestor obj = new _10CommonAncestor();

        Node node = obj.lowestCommonAncestor(head, head.right, head.right.right);
        System.out.println(node.value);
    }

    public Node lowestCommonAncestor(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node leftAncestor = lowestCommonAncestor(head.left,o1,o2);
        Node rightAncestor = lowestCommonAncestor(head.right,o1,o2);

        if(leftAncestor != null && rightAncestor != null){
            return head;
        }
        return leftAncestor != null ? leftAncestor : rightAncestor;
    }
}
