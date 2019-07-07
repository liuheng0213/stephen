package basic.knowledge.stephen.random;


import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.ArrayList;

public class RandomInRange {
    @Test
    public void testRandomInRange() {
        int[] nums = {4, 1, 12, 10, 7, 6, 22, 100, 30, 82};
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list1.removeAll(list2);
       System.out.println(list1.size());
//         while (true) {
//            int i = (int) (Math.random() * list1.size());
//            if (i == 0) {
//                System.out.println(list1.get(i));
//                return;
//            }
//
//        }
        /*System.out.println("i"+i+":"+nums[i]);
        i = (int) (Math.random() * nums.length);
        System.out.println("i"+i+":"+nums[i]);*/
    }

    @Test
    public void testMathRandom() {
//        for (int i = 0; i < 100; i++) {
//            int random = (int)(Math.random()*10);
//            System.out.println(random);
//
//        }

        for(int i = 1; i < 100; i++){
            int random = StdRandom.uniform(2);
//            if(random < 1 || random >10){
//                throw  new RuntimeException();
//            }

            System.out.println(random);
        }



    }
}
