package basic.knowledge.stephen.algorithm_4_Edition.mock;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.entity.User;

public class MockData {
    public static final Comparable[] FOR_SORT_MOCK = getUser();

    private static Comparable[] getUser() {

        return new User[]{new User(21), new User(3),new User(2),new User(14)
        ,new User(5),new User(16),new User(71),new User(18),new User(9), new User(0),
                new User(13)};
    }

    public static final Comparable[] DOUBLE_FOR_SORT_MOCK = new Double[]{0.0,1.0,2.0,1.2,1.3,1.0,8.0,4.5,3.6,7.2};
}
