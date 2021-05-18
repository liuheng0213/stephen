package basic.knowledge.stephen.ThreadRelevant._23threadMethod;

public class JoinDemo {
	public static void main(String[] args) throws Exception {
		System.out.println("begining");
		Thread joinThread = new Join();//��ͷһ��Ĳ�ͬ������û�������ำ����Thread joinThread = new Join()
		for (int i = 0; i < 50; i++) {
			System.out.println("main : " + i);
			if (i == 10) {
				//�����߳�
				joinThread.start();
			}
			
			if (i == 20) {
				joinThread.join();//ǿ��ִ�и��߳�,
			}
		}

		System.out.println("ending");
	}

}

class Join extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			System.out.println("join:" + i);
		}
	}
}
