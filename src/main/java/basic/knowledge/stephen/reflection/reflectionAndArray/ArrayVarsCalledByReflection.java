package basic.knowledge.stephen.reflection.reflectionAndArray;


import basic.knowledge.stephen.reflection.entity.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ArrayVarsCalledByReflection {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, Exception {
		// TODO Auto-generated method stub
		
		//transmitFundamentalData();
		
		transmitReferenceData();
	}

	private static void transmitReferenceData() throws ClassNotFoundException, Exception, SecurityException {
		// TODO Auto-generated method stub
		Class<?> clz = Class.forName("classes.Person");//oK��
		//Class<Person> clz = Person.class;
		Method m = clz.getDeclaredMethod("transmitArrayVars2", String[].class,int[].class);
		m.setAccessible(true);
		Object obj2 = m.invoke(clz.newInstance(), new Object[]{new String[]{"haha","heihei"},new int[]{11,22,33}});
		System.out.println(obj2);
	}

	public static void transmitFundamentalData() throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		//fundamental data
		Class<Person> clz = Person.class;
		Method m = clz.getDeclaredMethod("transmitArrayVars1", int[].class);
		m.setAccessible(true);
		Object obj1 = m.invoke(null, new int[]{11,22,33,44});
		System.out.println(obj1);
	}

}
