package basic.knowledge.stephen.ThreadRelevant._23threadMethod;

import java.util.*;

public class TimerDemo {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new XXX(),300,1000);
		//timer.cancel();
	}
}

class XXX extends TimerTask {			//timerTask��һ��������

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(new Date().toLocaleString());
	}
	
}

