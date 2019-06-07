package basic.knowledge.stephen.reflection.OtherApi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

abstract public class ModifierDemo {

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
		//��ȡ���η�
		Class<ModifierDemo> clz = ModifierDemo.class;
		int mod = clz.getModifiers();
		String str = Modifier.toString(mod);
		System.out.println(str);
		
		
		boolean b1 = Modifier.isPublic(mod);
		//boolean b2 = Modifier.isPublic(mod);
		System.out.println(b1);
		
		//��ȡ���Լ�����
		System.out.println(clz.getName());//come._520it.OtherApi.ModifierDemo
		System.out.println(clz.getSimpleName());//ModifierDemo
		
		//��ȡ��������
		System.out.println(clz.getSuperclass().getName());//java.lang.Object
		System.out.println(clz.getSuperclass());//class java.lang.Object
		
		//��֤ö��ͨ�����䴴������
		/*Constructor<Gender> con = Gender.class.getConstructor();
		con.setAccessible(true);//ö�ٵĹ�������˽�е�
		con.newInstance();		//����, �޷���ȡ,ö�ٲ����ܷ��䴴������*/
	}

}
enum Gender{
	MAN,WOMEN;
}
