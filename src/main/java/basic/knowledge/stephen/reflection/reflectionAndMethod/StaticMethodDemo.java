package basic.knowledge.stephen.reflection.reflectionAndMethod;


import basic.knowledge.stephen.reflection.entity.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StaticMethodDemo {

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Method m = new Person().getClass().getDeclaredMethod("show4", String.class);
		m.setAccessible(true);
		Object obj = m.invoke(null, "����");		//��̬�ķ������ﲻ�ô���  :  �ֽ������.newInstance();
		System.out.println(obj);
		
	}

}
