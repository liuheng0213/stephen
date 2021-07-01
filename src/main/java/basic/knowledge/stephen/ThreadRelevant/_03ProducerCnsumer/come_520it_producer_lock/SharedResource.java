package basic.knowledge.stephen.ThreadRelevant._03ProducerCnsumer.come_520it_producer_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
	private String name;
	private String gender;
	private boolean isEmpty = true;
	private final Lock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();

	public void push(String name, String gender) {
		lock.lock();//锁SharedResource这个资源
		try {
			while (!isEmpty) {
				condition.await();//如果有库存,释放当前线程占用得锁,阻塞当前线程
			}
			this.name = name;
			this.gender = gender;
			isEmpty = false;
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void popup() {
		lock.lock();
		try {
			while(isEmpty) {
				condition.await();
			}
			System.out.println(Thread.currentThread().getName() + "---" + name + "=" + gender);
			isEmpty = true;
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			lock.unlock();
		}
	}

}
