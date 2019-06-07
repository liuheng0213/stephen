package basic.knowledge.stephen.reflection._01_class_instance;

import java.util.Date;

public class ClassInstanceDemo {
	public static void main(String[] args) throws Exception {
		Date date = new Date();
		Class<? extends Date> clz = date.getClass();
		
		Class<Date> clz1 = Date.class;
		
		Class<?> clz2 = Class.forName("java.util.Date");
		
		System.out.println(clz== clz1);
		System.out.println(clz1== clz2);
	}
	
	
}
