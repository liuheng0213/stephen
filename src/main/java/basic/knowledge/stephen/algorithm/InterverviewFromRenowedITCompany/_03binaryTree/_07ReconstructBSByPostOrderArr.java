package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

/**
 * 按后序数组重建搜索二叉树
 */
public class _07ReconstructBSByPostOrderArr {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,7};
        //int[] arr = new int[]{1, 2, 3, 5, 6, 7, 4};
        //int[] arr = new int[]{1, 2, 3};
        //int[] arr = new int[]{2, 1, 3};
        _07ReconstructBSByPostOrderArr reconstructBSByPostOrderArr = new _07ReconstructBSByPostOrderArr();

        boolean postArr = reconstructBSByPostOrderArr.isPostArr(arr);
        System.out.println(postArr);
        Node node = reconstructBSByPostOrderArr.reconstruct(arr);
        System.out.println(node);
    }

    /**
     * 按后序数组重建搜索二叉树
     *
     * @param arr
     * @return
     */
    private Node reconstruct(int[] arr) {
        if (!isPostArr(arr)) {
            return null;
        }
        return reconstruct(arr, 0, arr.length - 1);
    }

    private Node reconstruct(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        Node head = new Node(arr[end]);
        // 找到less more
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        head.left = reconstruct(arr, start, less);
        head.right = reconstruct(arr, more, end - 1);
        return head;
    }

    private boolean isPostArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return isPostArr(arr, 0, arr.length - 1);
    }

    private boolean isPostArr(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        if (less == -1 || more == end) {
            return isPostArr(arr, start, end - 1);
        }
        if (less != more - 1) {
            return false;
        }

        return isPostArr(arr, start, less) && isPostArr(arr, more, end - 1);
    }


}
