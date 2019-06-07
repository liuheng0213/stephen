package basic.knowledge.stephen.ThreadRelevant._03ProducerCnsumer;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Express express = new Express();
		new Thread(new MailMan(express),"A").start();
		new Thread(new MailMan(express),"B").start();
		new Thread(new MailMan(express),"C").start();	
		
	}	
}

/**
 * 具体实现方法写在资源里
 * 具体方法加synchronize
 */
class Express {
	
	private int num = 1;
	
	synchronized public void sendMails() {
		
		if (num <= 100) {
			System.out.println(Thread.currentThread().getName() + "---发了第"
					+ num++ + "封邮件");
		}
	}
}

class MailMan implements Runnable {
	private Express express;
	
	public MailMan(Express express) {
		this.express = express;	
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			express.sendMails();
		}
	}
}
