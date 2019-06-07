package basic.knowledge.stephen.ThreadRelevant._15concurrentAPI.atomicReference;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 线程安全的更新
 */
public class AtomicReferenceTest {
    public static AtomicReference<User> atomicUserRef = new
            AtomicReference<User>();
    public static void main(String[] args) {
        User user = new User("hengh", 15);
        atomicUserRef.set(user);
        User updateUser = new User("Shinichi", 17);
        atomicUserRef.compareAndSet(user, updateUser);
        System.out.println(atomicUserRef.get().getName());
        System.out.println(atomicUserRef.get().getOld());
    }
    static class User {
        private String name;
        private int old;
        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }
        public String getName() {
            return name;
        }
        public int getOld() {
            return old;
        }
    }
}
