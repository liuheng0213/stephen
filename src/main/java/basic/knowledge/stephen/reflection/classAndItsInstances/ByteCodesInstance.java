 package basic.knowledge.stephen.reflection.classAndItsInstances;

import java.util.Date;

public class ByteCodesInstance {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//pattern 1 : how to get the instance of bytecodes
		//ͨ�����ַ����ǿ��Բ���ȫ�޶����Ƶ�������
		Class<Date> clz1 = Date.class;
		System.out.println(clz1);
		System.out.println(clz1.getName());
		System.out.println(clz1.getSimpleName());
		
		//Ϊʲô���ﷵ�ص���<? extends Date> ,��ȻAPIд�ķ���<?>
		Date date = new Date();
		Class<? extends Date> clz2 = date.getClass();		//ע�ⷵ�ص���class<?>
		System.out.println(clz2);
		
		System.out.println(clz1==clz2);
		//����������봫���ȫ�޶�����
		//Ϊʲô�����ǿת������뷵��<?> ; ��д <? extends Date >�����ǿת,��ΪforName()��Class�ľ�̬����,���õ�ʱ�򲢲�֪�����ĸ��������
		@SuppressWarnings("unchecked")
		Class<Date> clz3 = (Class<Date>) Class.forName("java.util.Date");		//ע����String 
		System.out.println(clz3);
		
		
		//��ȡ�Զ�������ֽ������
		Class<?> clz4 = Class.forName("classes.Person");
		System.out.println(clz4);
	}

}
