package basic.knowledge.stephen.exceptionAndFinally;

import basic.knowledge.stephen.ThreadRelevant._14threadGroup.groupAddThread.Run;

public class Cat extends Animal {
    @Override
    public void testException() {
        try {
            System.out.println(1/0);
        } catch (Exception e) {
            System.out.println("123 hh");
            System.out.println("123 hh1");
            System.out.println("123 hh2");
            System.out.println("123 hh3");
        }

    }
}
