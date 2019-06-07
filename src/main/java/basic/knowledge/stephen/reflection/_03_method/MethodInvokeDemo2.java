package basic.knowledge.stephen.reflection._03_method;


import basic.knowledge.stephen.reflection.entity.Person;

import java.lang.reflect.Method;


public class MethodInvokeDemo2 {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws NoSuchMethodException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, Exception {
		Class<Person> clz = Person.class;
		Person p = clz.newInstance();
		Method method = clz.getDeclaredMethod("transmitArrayVars1", int[].class);
		method.setAccessible(true);
		String str = (String) method.invoke(null, new int[]{1,2,4});
		System.out.println(str);
		
		Method method2 = clz.getDeclaredMethod("transmitArrayVars2", String[].class,int[].class);
		method2.setAccessible(true);
		Object obj = method2.invoke(p, new Object[]{new String[]{"AA","BB"},new int[]{11,22,33}});
		System.out.println(obj);
	}

}
