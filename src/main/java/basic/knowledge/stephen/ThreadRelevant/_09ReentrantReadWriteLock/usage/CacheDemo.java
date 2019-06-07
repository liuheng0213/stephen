package basic.knowledge.stephen.ThreadRelevant._09ReentrantReadWriteLock.usage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
    // 缓存的map
    private Map<String, Object> map = new HashMap<String, Object>();
    // 读写锁对象
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**
     * 从缓存中获取数据的方法
     * @param key
     * @return
     */
    /**
     * 设计一个缓存系统
     * 读写锁的应用。
     * JDK1.5自带的读写锁特性，读与读不互斥，读与写互斥，写与写互斥。
     * 为什么要使用读写锁？一句话概括那就是提高系统性能，如何提高呢？
     * 试想，对于所有对读的操作是不需要线程互斥的，而如果方法内
     * 使用了synchronized关键字同步以达到线程安全，对于所有的线程不管是读还是写的操作都要同步。
     * 这时如果有大量的读操作时就会又性能瓶颈。
     * 所以，当一个方法内有多个线程访问，并且方法内有读和写读操作时，
     * 提升性能最好的线程安全办法时采用读写锁的机制对读写互斥、写写互斥。这样对于读读就没有性能问题了
     * @author zhurudong
     *
     */
    public Object getData(String key) {
        readWriteLock.readLock().lock();//1 读锁，只对写的线程互斥, 此时其他线程依旧可以拿到读锁进行读操作, 读锁不互斥----A----
        Object value = null;
        try {
            // 尝试从缓存中读取数据,当前处于读锁状态,与写线程互斥
            value = map.get(key);
            if (value == null) {    //value==null 则进入if 需要写操作
                readWriteLock.readLock().unlock();//2 发现目标值为null,释放掉读锁,才可以上写锁,因为为Null所以要开始写了
                readWriteLock.writeLock().lock();//3 发现目标值为null,需要取值操作,上写锁,写程序执行的语句开始了---B----
                try {
                    value = map.get(key);// 很严谨这一步。再次取目标值,换了写锁后需要重新读取一次
                    if (value == null) {//很严谨这一步。防止当前线程执行到A.B之间时(此时当前线程无写锁)，后面获得写锁的线程再次进行取值get()操作
                        //因为有可能:当前线程执行到value = map.get(key);,另一写线程将map,put了一次,那么此时是不应该再put了
                        // 模拟DB操作
                        value = new Random().nextInt(10000) + "test";
                        map.put(key, value);
                        System.out.println("db completed!");
                    }
                    // 见笔记,线程获取写入锁后可以再次获取读取锁，但是读线程获取读取锁后却不能获取写入锁,所以此时另一个线程是不可以获取到写锁的
                    readWriteLock.readLock().lock();
                    /*这就是锁降级操作,写线程的写入锁转读取锁的话,步骤是先获取读取锁,再释放写入锁
                     * 先加读锁再释放写锁读作用：
                     * 这是锁降级的必备流程操作:防止在58行释放写锁之后41行出多个线程获得写锁进行写的操作，而当前key 已经有value了.所以在写锁还没有释放前要上读锁,
                     */
                } finally {
                    readWriteLock.writeLock().unlock();
                }
            }

        } finally {
            readWriteLock.readLock().unlock();//6如果value!=null,上面If语句不进入,释放读锁,返回value.
        }
        return value;
    }

    /**
     *  test main
     * @param args
     */
    public static void main(String[] args) {
        final CacheDemo cache = new CacheDemo();
        final String key = "user";
        for (int i = 0; i < 1000; i++) {
            new Thread(){
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"----->"+cache.getData(key));
                };
            }.start();
        }
    }

    /**
     * Output:
     * db completed!
     Thread-0----->4922test
     Thread-1----->4922test
     Thread-2----->4922test
     Thread-3----->4922test
     Thread-4----->4922test
     Thread-6----->4922test
     ......共1000个线程获得的都是同样的value

     */

}
