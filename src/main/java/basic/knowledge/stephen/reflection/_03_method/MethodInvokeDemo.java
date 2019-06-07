package basic.knowledge.stephen.reflection._03_method;



import basic.knowledge.stephen.reflection.entity.Person;

import java.lang.reflect.Method;

public class MethodInvokeDemo {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws NoSuchMethodException 
	 */
	public static void main(String[] args) throws Exception {
		Class<Person> clz = Person.class;
		Person p = clz.newInstance();
		Method m1 = clz.getDeclaredMethod("show1");
		m1.invoke(p);
		
		Method m2 = clz.getDeclaredMethod("show2", int.class);
		m2.setAccessible(true);//ȱʡ��ҲҪ����
		m2.invoke(p, 3);
		
		Method m3 = clz.getDeclaredMethod("show4",String.class);
		m3.setAccessible(true);
		String str = (String) m3.invoke(null, "������");
		System.out.println(str);
		
		
	}

}
