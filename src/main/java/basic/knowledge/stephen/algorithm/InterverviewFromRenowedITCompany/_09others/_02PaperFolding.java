package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

//折纸折痕问题
public class _02PaperFolding {
    public static void main(String[] args) {
        _02PaperFolding paperFolding = new _02PaperFolding();
        paperFolding.printAllFolds(2);
    }

    private void printAllFolds(int n) {
        printAllFolds(1, 2, true);
    }

    private void printAllFolds(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        printAllFolds(i + 1, n, true);
        System.out.println(down ? "down" : "up");
        printAllFolds(i + 1, n, false);
    }
}
