package basic.knowledge.stephen.reflection.reflectionAndArray;


import basic.knowledge.stephen.reflection.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


//ͨ��ӳ���ȡArrays��asList����,�÷��� ��������,����List
public class ArraysAsList {

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		// TODO Auto-generated method stub
		Class<Arrays> clz = Arrays.class;
		
		//ע������ĵڶ�������,Ӧ����ɶ
		Method m = clz.getMethod("asList", Object[].class);
		Class<Person> clz1 = Person.class;
		Constructor<Person> con = clz1.getDeclaredConstructor(String.class);
		con.setAccessible(true);
		Person p1 = con.newInstance("hengheng");
		@SuppressWarnings("unchecked")
		//����������뱨����  ʲô����
		//List<Person> list = (List<Person>) m.invoke(null, new Object[]{p1,new Person("juanjuan",17)});
		
		//����asList<T...a>,����ʵ�η�ʽ��ģ�±��������������͵�����Ĵ��뷽ʽ
		//����asList<T...a>  ����ת����
		
		List<Person> list = (List<Person>) m.invoke(null, new Object[]{new Person[]{p1,new Person("juanjuan",17)}});
		System.out.println(list);
	}
}

/*
 * �ǳ����˶�ӳ����˽�
 * */
