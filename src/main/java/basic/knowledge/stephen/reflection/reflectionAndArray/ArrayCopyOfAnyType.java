package basic.knowledge.stephen.reflection.reflectionAndArray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCopyOfAnyType {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Array��ӳ�伯�ϵ�һ��
		
		//�������������ʾ��ʽ����,���˴��õڶ���
		//int[] arr = new int[]{11,22,33,44,55};
		Object objArr = new int[]{11,22,33,44,55};
		System.out.println(objArr.getClass().getComponentType());
		//��ȡ,���ص���object--������,��󷵻����ض����͵�
		Object o1 = Array.get(objArr, 4);
		System.out.println(o1);
		
		//��ȡ,���ص���int
		int val = Array.getInt(objArr, 2);
		System.out.println(val);
		
		//����
		Array.set(objArr, 3, 35);
		System.out.println(Arrays.toString((int[])objArr));			//Ҫǿת
		
		System.out.println("---------------");
		
		//����
		int[] src = new int[]{1,2,3,4,5,6,7,8,9,10};
		int[] dest = new int[10];
		System.out.println(Arrays.toString(dest));
		
		System.out.println("---------------");
		ArrayCopy(src,3,dest,2,5);
		System.out.println(Arrays.toString(dest));
		
		
	}
	//�ô�,����Ӳ����,
	private static void ArrayCopy(Object src, int srcPos, Object dest, int destPos, int length) {
		// TODO Auto-generated method stub
		//�ų������ǿ�
		if (src == null || dest == null) {
			throw new NullPointerException("ԴĿ�겻��Ϊ�� ");
		}
		
		//�ų�ԭĿ�������
		if (!src.getClass().isArray() || !dest.getClass().isArray()) {
			throw new ArrayStoreException("Դ��Ŀ�������");
		}
		//��������Array.getLength(src),
		if (srcPos + length > Array.getLength(src) || destPos + length > Array.getLength(dest) || 
				srcPos < 0 || destPos < 0 || length < 0) {
			throw new ArrayIndexOutOfBoundsException("����Խ��");
		}
		
		//�ų���ͬһԪ��
		if (src.getClass().getComponentType() != dest.getClass().getComponentType()) {
			throw new ArrayStoreException("Դ��Ŀ��Ԫ�����ͱ���һ��");
		}
		
		//����
		for (int index = srcPos; index < srcPos + length; index++) {
			Object o = Array.get(src, index);
			//System.out.println(o);
			Array.set(dest, destPos++, o);
			
		}
		
		
	}

}
