package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

/**
 * Morris方法 遍历二叉树
 */
public class _00Morris {
    public static void main(String[] args) {
        Node head = new Node(4);

        head.left = new Node(2);
        head.left.left = new Node(1);
        head.left.right = new Node(3);

        head.right = new Node(6);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        _00Morris morris = new _00Morris();
        //morris.morris(head);
        //morris.morrisPre(head);
        //morris.morrisIn(head);
        morris.morrisPost(head);
    }

    /**
     * morris 后序遍历 原则：
     * 对于cur只能到达一次的节点(无左子节点) ，直接跳过 ，不打印
     * @param node
     */
    private void morrisPost(Node node) {
        //todo
    }

    /**
     * Morris中序遍历原则：
     * 对于cur只能到达一次的节点(无左子节点) ，直接打印
     * 对于cur能到达两次的节点(有左子节点)， cur必然到达两次，cur第一次达到时不打印，第二次打印
     * @param node
     */
    private void morrisIn(Node node) {
        if (node == null) {
            return;
        }
        Node cur = node;
        Node mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }

                //此时要么mostRight.right == null  要么 mostRight.right == cur
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                }else{
                    System.out.println("cur--> " + cur.value);
                    mostRight.right = null;
                    cur = cur.right;
                }
            }else{
                System.out.println("cur--> " + cur.value);
                cur = cur.right;
            }
        }
    }

    /**
     * Morris先序遍历原则：
     * 对于cur只能到达一次的节点(无左子节点) ，直接打印
     * 对于cur能到达两次的节点(有左子节点)， cur必然到达两次，cur第一次达到时打印，第二次不打印
     *
     * @param node
     */
    private void morrisPre(Node node) {
        if (node == null) {
            return;
        }
        Node cur = node;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;//因为mostRight是左子树上的最优节点
            if (mostRight != null) {// 因为有可能cur.left == null， 也就是 有可能没有左子树
                //找到最右子节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    System.out.println("cur--> " + cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                //cur 没有左子树
                System.out.println("cur--> " + cur.value);
                cur = cur.right;
            }
        }
    }

    private void morris(Node node) {
        if (node == null) {
            return;
        }
        Node cur = node;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;//因为mostRight是左子树上的最优节点
            if (mostRight != null) {// 因为有可能cur.left == null， 也就是 有可能没有左子树
                //找到最右子节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                //此时要么mostRight.right == null  要么 mostRight.right == cur
                if (mostRight.right == null) {
                    System.out.println("cur--> " + cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    System.out.println("cur--> " + cur.value);
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                System.out.println("cur--> " + cur.value);
                //cur 没有左子树
                cur = cur.right;
            }
        }
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
