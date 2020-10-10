package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

public class _10MaxDistanceInBT {
    public static void main(String[] args) {
        Node head = new Node(-3);
        head.left = new Node(3);
        head.left.left = new Node(1);
        head.left.right = new Node(0);

        head.left.right.left = new Node(1);
        head.left.right.right = new Node(6);
        head.left.right.right.left = new Node(-2);
        head.left.right.right.right = new Node(-8);

        head.right = new Node(-9);
        head.right.left = new Node(2);
        head.right.right = new Node(1);
        head.right.right.right = new Node(5);
        head.right.right.left = new Node(7);
        head.right.right.right.left = new Node(15);
        head.right.right.right.left.left = new Node(-4);
        head.right.right.right.left.left.left = new Node(10);

        _10MaxDistanceInBT maxDistanceInBT = new _10MaxDistanceInBT();
        int res = maxDistanceInBT.getMaxDistance(head);
        System.out.println(res);
    }

    private int getMaxDistance(Node head) {
        return process(head).maxDistance;
    }

    private ReturnType process(Node node) {
        if (node == null) {
            return new ReturnType(0, 0);
        }
        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        int maxDis = Math.max(Math.max(leftData.maxDistance, rightData.maxDistance), leftData.height + rightData.height + 1);

        return new ReturnType(maxDis, height);
    }


    class ReturnType {
        public int maxDistance;
        public int height;


        public ReturnType(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }
}
