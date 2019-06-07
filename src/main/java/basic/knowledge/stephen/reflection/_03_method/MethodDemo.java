package basic.knowledge.stephen.reflection._03_method;




import basic.knowledge.stephen.reflection.entity.Person;

import java.lang.reflect.Method;

public class MethodDemo {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws NoSuchMethodException 
	 */
	public static void main(String[] args) throws Exception {
		Class<Person> clz = Person.class;
		Method[] ms = clz.getMethods();//�õ����еİ�������ķ���
		System.out.println(ms.length);
		for (Method method : ms) {
			System.out.println(method);
		}
		
		System.out.println("--------------------");
		Method[] methods = clz.getDeclaredMethods();//�õ��Լ��ķ���,�����ķǹ�����
		System.out.println(methods.length);
		for (Method method : methods) {
			System.out.println(method);
		}
		System.out.println("--------------------");
		Method m1 = clz.getDeclaredMethod("show1");
		System.out.println(m1);
		Method m2 = clz.getDeclaredMethod("show2", int.class);
		System.out.println(m2);
		Method m3 = clz.getDeclaredMethod("show4",String.class);
		System.out.println(m3);
	}

}
