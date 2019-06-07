package basic.knowledge.stephen.reflection.classAndItsInstances;


import basic.knowledge.stephen.reflection.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class InstanceCreatingThroughRelection {

	/**
	 *����:
	 *1. ��ȡ�ֽ������
	 *2. �����Ĺ�����
	 *3.ͨ����������������
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws Exception 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, Exception {
		// TODO Auto-generated method stub
		//traditional
		/*new Person();*/
		
		//through reflection
		//createOne();
		
		createTwo();
		
		//createThree();
		
	}

	public static void createThree() throws NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		//��λ�ȡ��public�Ĺ�����,
		Class<Person> clz1 = Person.class;
		System.out.println(clz1);
		
		Constructor<Person> con = clz1.getDeclaredConstructor(String.class,int.class,int.class);
		con.setAccessible(true);		//���ڷ�public�Ĺ�����,��������ǰҪ�ô˷���
		Person p = con.newInstance("s",13,2);
		System.out.println(p);
	}

	public static void createTwo() throws NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		Class<Person> clz1 = Person.class;
		System.out.println(clz1);
		Constructor<Person> con = clz1.getConstructor(String.class,int.class);
		Person p = con.newInstance("hengheng",23);
		System.out.println(p);
	}

	public static void createOne() throws NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		Class<Person> clz1 = Person.class;
		System.out.println(clz1);
		
		//getConstructor()  ֻ�ܵõ������Ĺ��췽��
		Constructor<Person> con = clz1.getConstructor();
		
		//��������� 
		/*Class<?> clz2 = Class.forName("classes.Person");
		Constructor<Person> con2 = (Constructor<Person>) clz2.getConstructor();
		//��������������ֽ���,����ǿת
		 */		
		
		Person p1 = con.newInstance();
		System.out.println(p1);
	}

}
