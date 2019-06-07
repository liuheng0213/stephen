package basic.knowledge.stephen.reflection._01_class_instance;

import java.beans.Introspector;

public class DateTypeClassInstance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class intClass = int.class;
		Class byteClass = byte.class;
		Class shortClass = short.class;
		Class longClass = long.class;
		Class charClass = char.class;
		Class booleanClass = boolean.class;
		Class doubleClass = double.class;
		Class floatClass = float.class;
		Class voidClass = void.class;
		
		//�˴��������͵İ�װ�඼�г���TYPE �ɻ�ȡ��Ӧ�������͵��ֽ������
		System.out.println(Double.TYPE == doubleClass);
		
		//����Ϊ������������,Ԫ�����ͺ�ά����ͬ, �ֽ��빫��,��Ԫ�������޹�
		int[] arr1 = new int[]{1,2,3,4,5};
		int[] arr2 = new int[]{};
		
		System.out.println(arr1.getClass() == arr2.getClass());//true
		
	}

}
