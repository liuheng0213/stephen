package basic.knowledge.stephen.ThreadRelevant._03ProducerCnsumer.come_520it_producer_lock;

public class Producer implements Runnable {
	private SharedResource resource;
	
	public Producer(SharedResource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			if (i % 2== 0) {
				resource.push("AA", "GIRL");
			}else {
				resource.push("BB", "boy");
			}
		}
	}
	
	
}
