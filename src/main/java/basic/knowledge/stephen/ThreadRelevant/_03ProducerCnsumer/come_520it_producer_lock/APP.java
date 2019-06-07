package basic.knowledge.stephen.ThreadRelevant._03ProducerCnsumer.come_520it_producer_lock;

public class APP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SharedResource resource = new SharedResource();
		
		/*Producer producer = new Producer(resource);
		Thread th1 = new Thread(producer);
		th1.start();*/
		new Thread(new Producer(resource)).start();
		
		/*Consumer consumer = new Consumer(resource);
		Thread th2 = new Thread(consumer);
		th2.start();*/
		
		new Thread(new Consumer(resource),"A").start();
		
		
	}

}
