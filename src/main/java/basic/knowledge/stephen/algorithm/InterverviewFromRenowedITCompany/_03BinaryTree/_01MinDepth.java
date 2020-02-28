package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03BinaryTree;

public class _01MinDepth {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.left.left = new Node(4);
        head.left.left.right = new Node(6);
        head.left.left.right.right = new Node(7);

        head.right = new Node(3);
        head.right.left = new Node(5);
        head.right.left.left = new Node(10);

        int res = minDephth(head);
        System.out.println(res);
    }

    private static int minDephth(Node head) {
        if (head == null) {
            return 0;
        }

        return process(head, 1);
    }

    /**
     * 节点cur所在的深度为level的情况下
     * 遍历到cur子树中的所有节点，并且将最矮的叶节点高度返回
     *
     * @param cur
     * @param level
     * @return
     */
    private static int process(Node cur, int level) {
        if (cur.left == null && cur.right == null) {//此时cur没有子节点
            return level;
        }

        int ans = Integer.MAX_VALUE;
        if (cur.left != null) {
            ans = Math.min(process(cur.left, level + 1), ans);//此时深度深了一层
        }

        if (cur.right != null) {
            ans = Math.min(process(cur.right, level + 1), ans);
        }

        return ans;

    }

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
