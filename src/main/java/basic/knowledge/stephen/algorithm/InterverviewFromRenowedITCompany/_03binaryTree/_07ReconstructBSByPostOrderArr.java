package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

/**
 * 按后序数组重建搜索二叉树
 */
public class _07ReconstructBSByPostOrderArr {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 7};
        //int[] arr = new int[]{1, 2, 3, 5, 6, 7, 4};
        //int[] arr = new int[]{1, 2, 3};
        int[] arr1 = new int[]{1, 2, 3, 10, 15, 17, 14, 6};
        _07ReconstructBSByPostOrderArr obj = new _07ReconstructBSByPostOrderArr();

        boolean postArr = obj.isPostArr(arr1);
        System.out.println(postArr);
        Node node = obj.reconstruct(arr);
        System.out.println(node);
    }

    /**
     * 按后序数组重建搜索二叉树
     *
     * @param arr
     * @return
     */
    private Node reconstruct(int[] arr) {
        if (arr == null) {
            return null;
        } else if (arr.length == 0) {
            return null;
        }

        return reconstruct(arr, 0, arr.length - 1);
    }

    private Node reconstruct(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int less = -1;
        int more = end;
        for (int i = 0; i < end; i++) {
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        Node parent = new Node(arr[end]);
        parent.left = reconstruct(arr, start, less);
        parent.right = reconstruct(arr, more, end - 1);
        return parent;
    }

    private boolean isPostArr(int[] arr) {
        if (arr == null) {
            return false;
        } else if (arr.length == 0) {
            return false;
        }

        return isPostArr(arr, 0, arr.length - 1);
    }

    private boolean isPostArr(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }
        int less = -1; //也可以less == start - 1
        int more = end;
        for (int i = 0; i < end; i++) {
            if (arr[end] > arr[i]) {
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
