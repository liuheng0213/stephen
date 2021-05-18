package basic.knowledge.stephen.ThreadRelevant._23threadMethod;

public class DaemonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			System.out.println("main" + i);
			if (i == 10) {
				DaemonThread dh = new DaemonThread();
				dh.setDaemon(true);
				dh.start();
			}
		}
	}
}

class DaemonThread extends Thread{
	public void run() {
		for (int i = 0; i < 500; i++) {
			System.out.println(super.getName() + "-" + i);
		}
	}
}
