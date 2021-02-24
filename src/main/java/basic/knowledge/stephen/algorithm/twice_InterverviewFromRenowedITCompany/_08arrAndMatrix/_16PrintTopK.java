package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._08arrAndMatrix;


//打印N个各自有序的数组最大的TopK
//只要有Top K 基本和优先队列联系起来
//永远最多只有Top K的元素个数在堆中
public class _16PrintTopK {
    public static void main(String[] args) {
        _16PrintTopK obj = new _16PrintTopK();
        int[][] arr = new int[][]{{219, 405, 538, 845, 971}, {148, 558}, {52, 99, 348, 691}, {145, 276, 277, 348, 557}};
        obj.printTopK(arr, 5);

    }

    private void printTopK(int[][] matrix, int k) {
        if (matrix == null || matrix[0] == null || k < 1) {
            return;
        }
        HeapEle[] heapArr = new HeapEle[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int index = matrix[i].length - 1;
            heapArr[i] = new HeapEle(matrix[i][index], i, index);
            heapSwim(heapArr, i);
        }

        int heapEndIndex = heapArr.length - 1;
        for (int i = 0; i != k; i++) {
            System.out.println("topK is--->" + heapArr[0].value);
            if (heapArr[0].index != 0) {
                heapArr[0].value = matrix[heapArr[0].arrNum][--heapArr[0].index];
            } else {
                swap(heapArr, 0, heapEndIndex);
                heapEndIndex--;
            }
            heapSink(heapArr, 0, heapEndIndex);
        }
    }

    private void heapSink(HeapEle[] heapArr, int i, int endIndex) {
        while (i * 2 + 1 <= endIndex) {
            int j = i * 2 + 1;
            if (j + 1 <= endIndex && heapArr[j + 1].value > heapArr[j].value) {
                j++;
            }
            if (heapArr[i].value < heapArr[j].value) {
                swap(heapArr, i, j);
            }
            i = j;
        }

    }

    private void heapSwim(HeapEle[] heapArr, int i) {
        while ((i - 1) / 2 >= 0) {
            int j = (i - 1) / 2;
            if (heapArr[j].value < heapArr[i].value) {
                swap(heapArr, i, j);
            } else {
                break;
            }
            i = j;
        }
    }

    private void swap(HeapEle[] heapArr, int i, int j) {
        HeapEle temp = heapArr[i];
        heapArr[i] = heapArr[j];
        heapArr[j] = temp;
    }

    class HeapEle {
        int value;
        int arrNum;
        int index;

        public HeapEle(int value, int arrNum, int index) {
            this.value = value;
            this.arrNum = arrNum;
            this.index = index;
        }
    }
}
