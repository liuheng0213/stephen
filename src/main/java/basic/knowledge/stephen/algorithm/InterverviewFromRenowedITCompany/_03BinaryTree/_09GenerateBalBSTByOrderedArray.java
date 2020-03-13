package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03BinaryTree;

/**
 * 根据有序数组生产平衡搜索二叉树
 * 数组中间生产头结点，左边生成左子树，右边生成右子树
 */
public class _09GenerateBalBSTByOrderedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6, 7, 8, 10, 11, 14, 16};
        _09GenerateBalBSTByOrderedArray generateBalBSTByOrderedArray = new _09GenerateBalBSTByOrderedArray();
        Node node = generateBalBSTByOrderedArray.genBST(arr);
        System.out.println(node);
    }

    private Node genBST(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        return genBST(arr, 0, arr.length - 1);
    }

    private Node genBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node head = new Node(arr[mid]);
        head.left = genBST(arr, start, mid - 1);
        head.right = genBST(arr, mid + 1, end);
        return head;
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
