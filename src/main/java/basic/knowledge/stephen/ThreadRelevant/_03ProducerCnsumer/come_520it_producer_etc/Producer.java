package basic.knowledge.stephen.ThreadRelevant._03ProducerCnsumer.come_520it_producer_etc;

class Producer implements Runnable{
	private SharedResource resource;
	
	public Producer (SharedResource resource) {	//������������Ŀ�ľ���ʹ�ò�����,����ȷ��һ��������Դ,
		this.resource = resource;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <500; i++) {
			resource.countToTen();
		}
	}

	/*@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <50; i++) {
			if (i % 2== 0) {
					try {
						resource.push("春哥",Gender.MALE);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}else {
					try {
						resource.push("凤姐", Gender.FEMALE);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		}
	}*/
}
