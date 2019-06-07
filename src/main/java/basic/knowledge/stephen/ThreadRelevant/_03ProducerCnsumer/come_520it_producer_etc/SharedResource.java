package basic.knowledge.stephen.ThreadRelevant._03ProducerCnsumer.come_520it_producer_etc;

public class SharedResource{

	private String name;
	private Gender gender;
	private boolean isEmpty = true;
	
	synchronized public void push(String name, Gender gender) throws InterruptedException {
		try {
			while(!isEmpty) {
				this.wait();	//let current thread wait until....,
			}
			this.name= name;
			Thread.sleep(10);
			this.gender = gender;
			isEmpty = false;
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	 
	
	synchronized public void popup() {
		try {
			while(isEmpty) 
			{
				this.wait();
			}
			Thread.sleep(10);
			System.out.println("popup: " + name + "=" + gender);
			isEmpty = true;
			this.notify();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


enum Gender{
	MALE,FEMALE;
}



