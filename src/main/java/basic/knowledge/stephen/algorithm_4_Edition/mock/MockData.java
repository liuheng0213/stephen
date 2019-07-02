package basic.knowledge.stephen.algorithm_4_Edition.mock;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.entity.User;
import edu.princeton.cs.algs4.StdRandom;

public class MockData {
    public static final Double[] DOUBLE_FOR_SORT_MOCK = new Double[]{0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2,0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2,0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2,0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2,0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2,0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2,0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2};
    public static final User[] FOR_SORT_MOCK = getUser();
    public static final Integer[] INTEGER_FOR_SORT_MOCK = getRandomIntegerArray();

    private static Integer[] getRandomIntegerArray() {
        Integer[] a = new Integer[88];
        for(int t = 0;t<88;t++){
            for(int i = 0;i<88;i++){
                a[i] = StdRandom.uniform(88);
            }
        }
        return a;
    }

    private static User[] getUser() {

        return new User[]{new User(21), new User(3),new User(2),new User(14)
        ,new User(5),new User(16),new User(71),new User(18),new User(9), new User(0),
                new User(13)};
    }
}
