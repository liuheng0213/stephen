package basic.knowledge.stephen.reflection._02_constructor;

import java.lang.reflect.Constructor;

public class GetConstructor {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class<?> clz = Class.forName("Cooper.reflection.classes.Person");
		Constructor<?> con = clz.getConstructor();
		System.out.println(con);
		
		con = clz.getDeclaredConstructor(String.class);//����˷���,��Ϊ���������ǹ�����
		System.out.println(con);
		
		Constructor<?>[] cons = clz.getConstructors();//�õ������Ĺ�����
		System.out.println(cons.length);
		
		cons = clz.getDeclaredConstructors();
		System.out.println(cons.length);
		
		for (Constructor<?> con1 : cons) {
			System.out.println(con1);
		}
	}

}
