package basic.knowledge.stephen.ThreadRelevant._03ProducerCnsumer.come_520it_producer_etc;

class Consumer implements Runnable{
	private SharedResource resource;
	
	public Consumer(SharedResource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			// TODO Auto-generated method stub
			//resource.printCount();
			resource.popup();
		}
	}
}
