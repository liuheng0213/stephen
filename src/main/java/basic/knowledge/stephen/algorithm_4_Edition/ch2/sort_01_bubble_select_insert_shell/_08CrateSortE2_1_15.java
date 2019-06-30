package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class _08CrateSortE2_1_15 {

    private Integer[] positions;


    public _08CrateSortE2_1_15(int n) {
        this.positions = new Integer[n];

        for (int i = 0; i < n; i++) {
            positions[i] = i + 1;
        }

        StdRandom.shuffle(positions);
    }

    public void moveCrate(Integer[] positions) {
        Integer temp = null;
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] != i + 1) {
                temp = positions[i];
                positions[i] = null;
                //找到小的
                for (int j = i + 1; j < positions.length; j++) {
                    if (positions[j] == i + 1) {
                        positions[i] = positions[j];
                        positions[j] = null;
                        positions[j] = temp;
                        temp = null;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        _08CrateSortE2_1_15 sort = new _08CrateSortE2_1_15(25);
        sort.moveCrate(sort.positions);
        System.out.println(Arrays.toString(sort.positions));
    }
}
