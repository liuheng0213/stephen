package basic.knowledge.stephen.reflection.reflectionAndMethod;



import basic.knowledge.stephen.javaCollections.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class MethodDemo {

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Class<Person> clz = Person.class;
		
		/*Method[] methods = clz.getMethods();		//��ȡ���еĲ��������������̳еķ���
		System.out.println(methods);
		System.out.println(methods.length);
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i]);
		}*/
		
		/*//��ȡ���з���������
		Method[] declaredMethods = clz.getDeclaredMethods();//��ȡ��������з���
		System.out.println(declaredMethods);
		for (Method method : declaredMethods) {
			System.out.println(method);
		}*/
		
		
		//get specified method
		/*getMethod(String name, Class<?>... parameterTypes) 
		����һ�� Method ��������ӳ�� Class ��������ʾ�����ӿڵ�ָ��������Ա������*/
		
		//��ȡ3������
		Method m1 = clz.getMethod("toString");
		Method m2 = clz.getDeclaredMethod("show2", int.class);
		Method m3 = clz.getDeclaredMethod("show3", int.class,String.class);
		
		//����3������---ͨ��ӳ��
		//��һ��: ��ȡPerson���ֽ���,-----------�Ѿ���ȡ��!
		//�ڶ���: ��ȡ����----�Ѿ���ȡ
		
		//���÷���֮��һ��: ��ȡ����
		
		
		Constructor<Person> con1 = clz.getDeclaredConstructor(String.class,int.class,int.class);
		con1.setAccessible(true);
		Person p1 = con1.newInstance("����",23,24);
		Object obj1 = m1.invoke(p1);
		System.out.println(obj1);
	
		//����toString()����
		Object obj2 = m1.invoke(clz.newInstance());//obj1ΪtoString()���ص�string, ���Ǳ�obj1������
		System.out.println(obj2);		
		
		//����show2()����
		m2.setAccessible(true);		//����Ȩ�޴ﲻ����,��������
		m2.invoke(clz.newInstance(), 3);//ֱ�Ӵ�ӡ�ᱨ��java.lang.IllegalAccessException
		
		//����show3()
		m3.setAccessible(true);
		m3.invoke(clz.newInstance(), 1000,"String");
		
		Date date = new Date();
		Class<? extends Date> class1 = date.getClass();
		
		
	}
}
