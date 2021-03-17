package basic.knowledge.stephen.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class TypicalTemplate {
    static List<List<Integer>> resTest = new ArrayList<>();
    static List<Integer> subResTest = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2};
        boolean[] used = new boolean[3];
        TypicalTemplate typicalTemplate = new TypicalTemplate();
        typicalTemplate.combine(resTest, subResTest, arr, 0,used);
        System.out.println(resTest);
    }

    private void combine(List<List<Integer>> resTest, List<Integer> subResTest, int[] arr, int n,boolean[] used) {
        if (n == arr.length) {
            resTest.add(new ArrayList<>(subResTest));
            return;
        }


        for (int i = n; i < arr.length; i++) {//test when int i = 0; or int i = n ?
            //todo  if a boolean[] used has been passed here  we could use if(!used[i]) to skip some node during traversing , but dont forget to set used[i] = false
            //todo  :sometimes , there may be : if continue statement

            subResTest.add(arr[i]);
            combine(resTest, subResTest, arr, n + 1,used);//test when i + 1 or n + 1
            subResTest.remove(subResTest.size() - 1);

            //todo  if use if(!used[i]) to skip some node during traversing ,  dont forget to set used[i] = false here
        }

    }
}
